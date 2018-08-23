package cn.kay.zhazha.controllers;

import cn.kay.zhazha.services.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;

@Controller
@RequestMapping(value = "/attend")
public class AttendanceController {

    private AttendService attendService;

    @Autowired
    public void setProductService(AttendService attendService) {
        this.attendService = attendService;
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String process(Model model, File file1, File file2) {
        /*model.addAttribute("products", productService.listAllProducts());*/

        return "result";
    }
}
