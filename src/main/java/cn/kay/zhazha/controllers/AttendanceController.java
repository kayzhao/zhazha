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
                          @RequestParam MultipartFile attendExcel) throws Exception {
        /*model.addAttribute("products", productService.listAllProducts());*/
        if (unclockExcel == null || attendExcel == null || unclockExcel.isEmpty() || attendExcel.isEmpty()) {
            model.addAttribute("errorInfo", "未上传打卡表或者考勤表");
            return "unclock";
        }
        File result = attendService.processExcel(unclockExcel.getInputStream(), attendExcel.getInputStream());
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/unclockhtml")
    String indexHtml() {
        return "unclockhtml";
    }


    @PostMapping(value = "/unclockhtml")
    public String processHtml(Model model,
                              @RequestParam MultipartFile unclockExcel,
                              @RequestParam MultipartFile attendExcel) throws Exception {
        /*model.addAttribute("products", productService.listAllProducts());*/
        if (unclockExcel == null || attendExcel == null || unclockExcel.isEmpty() || attendExcel.isEmpty()) {
            model.addAttribute("errorInfo", "未上传打卡表或者考勤表");
            return "unclock";
        }
        File result = attendService.processExcel(unclockExcel.getInputStream(), attendExcel.getInputStream());
        model.addAttribute("result", result);
        return "result";
    }
}
