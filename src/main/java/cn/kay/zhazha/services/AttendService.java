package cn.kay.zhazha.services;


import java.io.File;
import java.io.InputStream;

public interface AttendService {
    public File processExcel(InputStream f1, InputStream f2) throws Exception;

    public File processHtml(InputStream f1, InputStream f2) throws Exception;
}
