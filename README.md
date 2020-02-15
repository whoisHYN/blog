#### 1. 项目结构
本项目是基于 Spring Boot 的博客系统，参考主流博客网站实现了博客管理、发布、前端展示等功能模块，整体风格简约美观。
项目整体结构如下:
![项目结构](https://img-blog.csdnimg.cn/20200215210401850.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIwNzA1Ng==,size_16,color_FFFFFF,t_70)
> 项目结构

后端包含管理员登录、博客管理、分类管理和标签管理四大模块。前端基于 Semantic UI 完成了首页、分类、标签和归档等展示和管理页面的构建。
#### 2. 技术栈与开发环境
* 后端：Spring Boot + MyBatis + Thymeleaf 模板
* 数据库：MySQL
* 缓存：Redis
* 前端：Semantic UI
* 工具与环境： JDK 8 + IDEA + WebStorm + Maven 3 + Git 

#### 3. 主要页面展示
##### 3.1 首页
这是博客系统的首页，管理员和访客可以在这里浏览所有的博客，也可以使用全局搜索查询想看的博客，所有博客均按类型和标签做好分类，用户可以按需查看。
![首页](https://img-blog.csdnimg.cn/20200215212043414.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIwNzA1Ng==,size_16,color_FFFFFF,t_70)

##### 3.2 博客详情页
 这是博客详情页面，可以查看博客全文，右下角有悬浮按钮，用户可以做快捷操作，文末有评论版块，读者可以对博客进行评论。
![博客详情页](https://img-blog.csdnimg.cn/20200215211842775.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIwNzA1Ng==,size_16,color_FFFFFF,t_70)
##### 3.3 博客管理页面
管理员可以在这里进行增删编辑博客、分类和标签等操作。
![博客管理界面](https://img-blog.csdnimg.cn/20200215204157458.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzIwNzA1Ng==,size_16,color_FFFFFF,t_70)







