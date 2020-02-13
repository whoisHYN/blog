package com.hyn.web.admin;

import com.hyn.entity.Blog;
import com.hyn.entity.User;
import com.hyn.service.BlogService;
import com.hyn.service.TagService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: HYN
 * @Description:
 * @Date: 2020/2/8 10:57 上午
 * @Modified By:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    public static final String INPUT = "admin/blogs-input";
    public static final String LIST = "admin/blogs";
    public static final String REDIRECT_LIST = "redirect:/admin/blogs";

    private final BlogService blogService;
    private final TypeService typeService;
    private final TagService tagService;

    public BlogController(BlogService blogService, TypeService typeService, TagService tagService) {
        this.blogService = blogService;
        this.typeService = typeService;
        this.tagService = tagService;
    }

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blogQuery, Model model) {
        //把所有Type返回给前端页面用于查询下拉列表展示
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blogQuery, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String addBlog(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog,RedirectAttributes attributes, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));

        Blog blog1 = blogService.saveBlog(blog);
        if (blog1 == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return REDIRECT_LIST;
    }
}
