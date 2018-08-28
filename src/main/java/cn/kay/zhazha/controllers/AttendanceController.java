package cn.kay.zhazha.controllers;

import cn.kay.zhazha.domain.RequestObject;
import cn.kay.zhazha.services.AttendService;
import cn.kay.zhazha.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

@Controller
public class AttendanceController {

    @Autowired
    private AttendService attendService;

    @GetMapping("/unclock")
    String index() {
        return "unclock";
    }


    @PostMapping(value = "/unclock")
    public String process(Model model,
                          @RequestParam MultipartFile unclockExcel,
                          @RequestParam MultipartFile attendExcel,
                          @RequestParam Integer year, @RequestParam Integer month) throws Exception {
        /*model.addAttribute("products", productService.listAllProducts());*/
        if (unclockExcel == null || attendExcel == null || unclockExcel.isEmpty() || attendExcel.isEmpty()) {
            model.addAttribute("errorInfo", "未上传打卡表或者考勤表");
            return "unclock";
        }
        Calendar calendar = Calendar.getInstance();
        if (year == null)
            year = Calendar.YEAR;
        if (month == null)
            month = Calendar.MONTH;
        File result = attendService.processExcel(unclockExcel.getInputStream(), attendExcel.getInputStream(), year, month);
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/fingerprint")
    String indexHtml() {
        return "fingerprint";
    }


    @PostMapping(value = "/fingerprint")
    public String processHtml(Model model,
                              @RequestParam MultipartFile unclockExcel,
                              @RequestParam MultipartFile attendExcel) throws Exception {
        /*model.addAttribute("products", productService.listAllProducts());*/
        if (unclockExcel == null || attendExcel == null || unclockExcel.isEmpty() || attendExcel.isEmpty()) {
            model.addAttribute("errorInfo", "未上传打卡表或者考勤表");
            return "unclock";
        }
        //File result = attendService.processExcel(unclockExcel.getInputStream(), attendExcel.getInputStream());
        //model.addAttribute("result", result);
        return "result";
    }


    @GetMapping(value = "/download")
    public String down(Model model) throws Exception {
        model.addAttribute("result", null);
        return "result";
    }
}
