package com.minzheng.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.minzheng.blog.vo.TagVO;
import lombok.Data;

/**
 * 标签
 *
 * @author xiaojie
 * @since 2020-05-18
 */
@Data
@TableName("tb_tag")
public class Tag {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 创建时间
     */
    private Date createTime;

    public Tag(TagVO tagVO) {
        this.id = tagVO.getId();
        this.tagName = tagVO.getTagName();
        this.createTime = this.id == null ? new Date() : null;
    }

    public Tag() {
    }

}
