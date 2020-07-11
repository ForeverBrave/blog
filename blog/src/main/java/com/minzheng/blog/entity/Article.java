package com.minzheng.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.minzheng.blog.utils.UserUtil;
import com.minzheng.blog.vo.ArticleVO;
import lombok.Data;

/**
 * 文章
 *
 * @author xiaojie
 * @since 2020-05-18
 */
@Data
@TableName("tb_article")
public class Article {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作者
     */
    private Integer userId;

    /**
     * 文章分类
     */
    private Integer categoryId;

    /**
     * 文章缩略图
     */
    private String articleCover;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 内容
     */
    private String articleContent;

    /**
     * 发表时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 是否为草稿
     */
    private Integer isDraft;

    /**
     * 状态码
     */
    private Integer isDelete;

    public Article(ArticleVO articleVO) {
        this.id = articleVO.getId();
        this.userId = UserUtil.getLoginUser().getUserInfoId();
        this.categoryId = articleVO.getCategoryId();
        this.articleCover = articleVO.getArticleCover();
        this.articleTitle = articleVO.getArticleTitle();
        this.articleContent = articleVO.getArticleContent();
        this.createTime = this.id == null ? new Date() : null;
        this.updateTime = this.id != null ? new Date() : null;
        this.isTop = articleVO.getIsTop();
        this.isDraft = articleVO.getIsDraft();
    }

    public Article(Integer id) {
        this.id = id;
        this.isTop = 0;
    }

    public Article(Integer id, Integer isTop) {
        this.id = id;
        this.isTop = isTop;
    }

    public Article() {
    }

}
