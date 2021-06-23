package com.uady.apijaguar.controller;

import com.uady.apijaguar.dto.Mensaje;
import com.uady.apijaguar.service.servicios.FileTransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/v1/file")
@CrossOrigin
public class FileController {
    @Autowired
	private FileTransferService fileTransferService;

    private Logger logger = LogManager.getLogger(this.getClass());

    @GetMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestBody MultipartFile file,@RequestParam(name="ruta") String ruta) {
       
        boolean isUploaded = fileTransferService.uploadMultipartFile(file, ruta);
		logger.info("Upload result: " + String.valueOf(isUploaded));
        
        return new ResponseEntity(new Mensaje("El archivo se ha almacenado con éxito"),HttpStatus.OK);
    }
}
