package com.uady.apijaguar.service.servicios;

import org.springframework.web.multipart.MultipartFile;

public interface FileTransferService {
	
	boolean uploadFile(String localFilePath, String remoteFilePath);
	
	boolean downloadFile(String localFilePath, String remoteFilePath);

    boolean uploadMultipartFile(MultipartFile file, String remothePath);

}