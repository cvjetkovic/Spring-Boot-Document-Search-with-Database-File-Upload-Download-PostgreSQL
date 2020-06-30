package com.example.filedemo.repository;

import com.example.filedemo.model.law_multiple_files.LawMultipleFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBMultipleFileRepository extends JpaRepository<LawMultipleFiles, String> {

}
