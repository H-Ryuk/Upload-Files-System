package com.hassan.uploadfilesystem.service;


import com.hassan.uploadfilesystem.model.MyFile;
import com.hassan.uploadfilesystem.repository.MyFileRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MyFileService {

    private final MyFileRepo myFileRepo;


    public MyFileService(MyFileRepo myFileRepo) {
        this.myFileRepo = myFileRepo;
    }


    public void save(MultipartFile myData) {
        MyFile myFile = new MyFile();
        myFile.setFileName(myData.getOriginalFilename());
        myFile.setFileType(myData.getContentType());
        myFile.setFileSize(myData.getSize());

        try (InputStream inputStream = myData.getInputStream()) {
            byte[] data = inputStream.readAllBytes();
            myFile.setDataFile(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myFileRepo.save(myFile);


    }


}
