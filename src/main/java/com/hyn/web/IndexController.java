package com.hyn.web;

import com.hyn.exception.NotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/5 11:38 上午
 * @Modified By:
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
//        int i = 1 / 0;
        /*String blog = null;
        if (blog == null) {
            throw new NotFindException("博客不存在QAQ");
        }*/
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/blog1")
    public String blog1() {
        return "error/404";
    }
}
