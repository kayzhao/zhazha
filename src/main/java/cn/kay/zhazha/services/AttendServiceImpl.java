package cn.kay.zhazha.services;

import cn.kay.zhazha.domain.UnClock;
import cn.kay.zhazha.utils.ExcelUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Component
public class AttendServiceImpl implements AttendService {

    @Override
    public File processExcel(InputStream f1, InputStream f2) throws Exception {
        Map<String, UnClock> unClockMap = ExcelUtils.readUnClockExcel(f1);
        System.out.println(unClockMap.size());
        return null;
    }

    @Override
    public File processHtml(InputStream f1, InputStream f2) throws Exception {
        Map<String, UnClock> unClockMap = ExcelUtils.readUnClockExcel(f1);
        System.out.println(unClockMap.size());
        return null;
    }
}
