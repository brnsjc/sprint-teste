package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//@Service
public interface StorageService {

	void init();
	void store(MultipartFile file);
	
}
