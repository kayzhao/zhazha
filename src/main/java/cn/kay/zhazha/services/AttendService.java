package cn.kay.zhazha.services;


import java.io.File;
import java.io.InputStream;

public interface AttendService {
    public File processExcel(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception;

    public File processFingerprint(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception;
}
