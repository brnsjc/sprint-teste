package com.example.demo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.StorageProperties;
import com.example.demo.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService{

	private Path rootLocation;
	
	@Autowired
	public StorageServiceImpl(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stub
		String filename = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		
		 //rootLocation = Paths.get(this.getClass().getResource("/").getPath());
	        //Path newFolder = Paths.get(source.toAbsolutePath() + "/newFolder/");
		
		
	       
		
		try {
			
			InputStream input = file.getInputStream();
			System.out.print(file.getInputStream());
			System.out.print(rootLocation.toAbsolutePath());
			System.out.println(rootLocation.toAbsolutePath());
			//Files.copy(input, this.rootLocation.resolve(filename));
			Files.copy(input, rootLocation.toAbsolutePath().resolve(filename));
			
			InputStream is = new ByteArrayInputStream(new byte[] { 0, 1, 2 }); // not really unknown
			 
		    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		    int nRead;
		    String outputFile = "C:\\Users\\brunomoreira\\Desktop\\bin.txt";
		    OutputStream outputStream = new FileOutputStream(outputFile);
		    byte[] data = new byte[1024];
		    InputStream inputStream = new FileInputStream(outputFile);
		    buffer.flush();
		    byte[] byteArray = buffer.toByteArray();
		    
		    long fileSize = new File(outputFile).length();
		    
            byte[] allBytes = new byte[(int) fileSize];
 
            inputStream.read(allBytes);
 
            outputStream.write(allBytes);
		    
		    while ((nRead = is.read(data, 0, data.length)) != -1) {
		        buffer.write(data, 0, nRead);
		       
		    }
		    
		   
		   
		    //Files.copy(byteArray, rootLocation.toAbsolutePath().resolve(filename));
		
		}catch(IOException ex) {}
		
	}

}
