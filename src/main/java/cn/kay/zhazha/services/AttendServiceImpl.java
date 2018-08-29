package cn.kay.zhazha.services;

import cn.kay.zhazha.domain.UnClock;
import cn.kay.zhazha.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

@Component
public class AttendServiceImpl implements AttendService {

    @Override
    public String processExcel(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception {
        Map<String, UnClock> unClockMap = ExcelUtils.readUnClockExcel(f1, year, month);
        HSSFWorkbook hssfWorkbook = ExcelUtils.countExcel(unClockMap, f2, year, month);
        String fileName = "result.xls";
        ClassPathResource resource = new ClassPathResource("result/" + fileName);
        hssfWorkbook.write(resource.getFile());
        hssfWorkbook.close();
        return fileName;
    }

    @Override
    public String processFingerprint(InputStream f1, InputStream f2, Integer year, Integer month) throws Exception {
        Map<String, UnClock> unClockMap = ExcelUtils.readUnClockExcel(f1, year, month);
        System.out.println(unClockMap.size());
        return null;
    }

    @Override
    public ResponseEntity<FileSystemResource> export(File file, String type) {
        if (file == null || type == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }
}
