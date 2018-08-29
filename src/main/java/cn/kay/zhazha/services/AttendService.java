package cn.kay.zhazha.services;


import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.InputStream;

public interface AttendService {
    public String processExcel(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception;

    public String processFingerprint(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception;

    public ResponseEntity<FileSystemResource> export(File file, String type);
}
