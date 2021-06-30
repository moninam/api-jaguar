package com.uady.apijaguar.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CuentaPrincipal implements UserDetails {
    private String email;
    private String alias;
    private String password;
    private String secret;
    private Boolean isBanned;
    private Date registerDate;
    private Date lastUpdate;
    private Collection<? extends GrantedAuthority> authorities;

    public CuentaPrincipal(String email, String alias, String password,String token,
            Boolean isBanned,Date registerDate,Date lastUpdate,
            Collection<? extends GrantedAuthority> authorities)
    {
        this.email = email;
        this.alias = alias;
        this.password = password;
        this.secret = token;
        this.isBanned = isBanned;
        this.registerDate = registerDate;
        this.lastUpdate = lastUpdate;
        this.authorities = authorities;
    }

    public static CuentaPrincipal build(Cuenta cuenta){
        List<GrantedAuthority> authorities = 
                cuenta.getRol().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                .collect(Collectors.toList());
                
        return new CuentaPrincipal(
            cuenta.getEmail(),
            cuenta.getAlias(),
            cuenta.getPassword(),
            cuenta.getSecret(),
            cuenta.getIsBanned(),
            cuenta.getRegisterDate(),
            cuenta.getLastUpdate(),
            authorities
        );
    }

    //GETTERS
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return alias;
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSecret(){
        return this.secret;
    }

    public Boolean isBanned(){
        return this.isBanned;
    }

    public Date getRegisterDate(){
        return this.registerDate;
    }

    public Date getLastUpDate(){
        return this.lastUpdate;
    }
}
