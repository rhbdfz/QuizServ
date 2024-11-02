package com.alekseyd.spring.springboot.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MyExcelService {

    public void saveExcelData(MultipartFile file) throws IOException;
}
