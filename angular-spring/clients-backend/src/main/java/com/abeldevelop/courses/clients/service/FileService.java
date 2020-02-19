package com.abeldevelop.courses.clients.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public Resource download(String fileName) throws MalformedURLException;
	
	public String upload(MultipartFile multipartFile) throws IOException;
	
	public boolean delete(String fileName);
	
	public Path getProfilePhotosPath(String fileName);
	
	public Path getStaticImagesResourcesPath(String fileName);
}
