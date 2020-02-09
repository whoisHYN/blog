package com.hyn.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/8 10:57 上午
 * @Modified By:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String blogs() {
        return "admin/blogs";
    }

    @GetMapping("/addType")
    public String addType() {
        return "admin/types-input";
    }
}
