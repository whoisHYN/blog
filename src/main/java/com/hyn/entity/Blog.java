package com.hyn.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: HYN
 * @Description:
 * @Modified By:
 */
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    /**博客标题*/
    @NotBlank(message = "标题不能为空")
    private String title;

    /**博客内容,长文本类型*/
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @NotBlank(message = "内容不能为空")
    private String content;
    /**头图*/
    @NotBlank(message = "头图不能为空")
    private String firstPic;
    /**原创/翻译/转载*/
    private String flag;
    /**阅读数*/
    private Integer views;
    /**开启赞赏*/
    private Boolean appreciation;
    /**是否发布*/
    private Boolean published;
    /**开启版权声明*/
    private Boolean shareStatement;
    /**是否推荐*/
    private Boolean recommend;
    /**开启评论*/
    private Boolean comment;
    /**创建日期*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**修改日期*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    /**博客描述*/
    private String description;

    /**分类*/
    @ManyToOne
    private Type type;

    /**标签，一篇博客对应多个标签*/
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    /**用户*/
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPic() {
        return firstPic;
    }

    public void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getComment() {
        return comment;
    }

    public void setComment(Boolean comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 由于数据库未存储tagIds变量，需要在这里为其赋值
     */
    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    /**
     * 利用tags获取tagIds，供前端使用
     * @param tags
     */
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Tag tag : tags) {
                sb.append(tag.getId());
                sb.append(",");

            }
            String str = sb.toString();
            return str.substring(0, str.length() - 1);
        }
        return tagIds;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPic='" + firstPic + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", published=" + published +
                ", shareStatement=" + shareStatement +
                ", recommend=" + recommend +
                ", comment=" + comment +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                '}';
    }
}
