package com.uady.apijaguar.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.uady.apijaguar.dto.JwtDto;
import com.uady.apijaguar.model.CuentaPrincipal;
import com.uady.apijaguar.service.CuentaService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class JwtProvider {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    CuentaService cuentaService;

    @Value("#{new Integer('${jwt.expiration}')}")
    private int expiration;

    public String generateToken(Authentication auth){
        CuentaPrincipal cuentaPrincipal = (CuentaPrincipal) auth.getPrincipal();
        List<String> roles = cuentaPrincipal.getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(cuentaPrincipal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getAliasFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        }catch(MalformedJwtException e){
            logger.error("Token malformado");
        }catch(UnsupportedJwtException e){
            logger.error("Token no soportado");

        }catch(ExpiredJwtException e){
            logger.error("Token expirado");

        }catch(IllegalArgumentException e){
            logger.error("Token Vacio");

        }catch(SignatureException e){
            logger.error("Fallo en la firma");

        }
        return false;
    }
    public String refreshToken(JwtDto jwtDto) throws ParseException{
        JWT jwt = JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claims = jwt.getJWTClaimsSet();
        String alias = claims.getSubject();
        List<String> roles = (List<String>)claims.getClaim("roles");
        
        return Jwts.builder()
                .setSubject(alias)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
