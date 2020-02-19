package com.abeldevelop.courses.clients.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.abeldevelop.courses.clients.service.FileService;

@Component
public class FileServiceImpl implements FileService {

	private static final String UPLOAD_PROFILE_PHOTOS_DIRECTORY = "profile-images";
	private static final String STATIC_IMAGES_RESOURCES = "src/main/resources/static/images";
	private static final String NO_PROFILE_IMG = "no-profile-img.png";
	
	@Override
	public Resource download(String fileName) throws MalformedURLException {
		Path filePath = getProfilePhotosPath(fileName);
		
		Resource resource = new UrlResource(filePath.toUri());
		
		if(!resource.exists() || !resource.isReadable()) {
			filePath = getStaticImagesResourcesPath(fileName);
			resource = new UrlResource(filePath.toUri());
		}
		
		return resource;
	}

	@Override
	public String upload(MultipartFile multipartFile) throws IOException {
		String fileName = null;
		if(!multipartFile.isEmpty()) {
			fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename().replace(" ", "");
			Path filePath = getProfilePhotosPath(fileName);
			Files.copy(multipartFile.getInputStream(), filePath);
		}
		return fileName;
	}

	@Override
	public boolean delete(String fileName) {
		if(!StringUtils.isEmpty(fileName)) {
			Path previousFilePath = getProfilePhotosPath(fileName);
			File filePrevious = previousFilePath.toFile();
			if(filePrevious.exists() && filePrevious.canRead()) {
				return filePrevious.delete();
			}
		}
		return false;
	}

	@Override
	public Path getProfilePhotosPath(String fileName) {
		return Paths.get(UPLOAD_PROFILE_PHOTOS_DIRECTORY).resolve(fileName).toAbsolutePath();
	}

	@Override
	public Path getStaticImagesResourcesPath(String fileName) {
		return Paths.get(STATIC_IMAGES_RESOURCES).resolve(NO_PROFILE_IMG).toAbsolutePath();
	}
	
}
