package com.hyn.web.admin;

import com.hyn.entity.Blog;
import com.hyn.service.BlogService;
import com.hyn.service.TypeService;
import com.hyn.vo.BlogQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    private final BlogService blogService;
    private final TypeService typeService;

    public BlogController(BlogService blogService, TypeService typeService) {
        this.blogService = blogService;
        this.typeService = typeService;
    }

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blogQuery, Model model) {
        //把所有普Type返回给前端页面用于查询下拉列表展示
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blogQuery, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/addType")
    public String addType() {
        return "admin/types-input";
    }
}
