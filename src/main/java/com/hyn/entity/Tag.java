package com.hyn.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "t_tags")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "类型名称不能为空！")
    private String name;

    /**一篇文章可以对应多个标签，一个标签也可以对应多篇文章*/
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
