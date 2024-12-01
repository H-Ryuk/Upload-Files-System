package com.hassan.uploadfilesystem.repository;

import com.hassan.uploadfilesystem.model.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyFileRepo extends JpaRepository<MyFile, Long> {
}
