package com.hassan.uploadfilesystem.controller;

import com.hassan.uploadfilesystem.service.MyFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("api/v1/upload")
public class MyController {


    private final MyFileService myFileService;

    public MyController(MyFileService myFileService) {
        this.myFileService = myFileService;
    }


    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file selected.");
        }
        myFileService.save(file);
        return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully!");
    }


    @GetMapping("/")
    public String index() {
        return "index.html";
    }



}
