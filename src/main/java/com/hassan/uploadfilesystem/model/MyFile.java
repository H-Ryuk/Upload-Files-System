package com.hassan.uploadfilesystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFile;
    @Lob
    private byte[] dataFile;
    private String fileName;
    private String fileType;
    private Long fileSize;

}
