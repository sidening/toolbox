package com.smilerro.toolbox.entity.blog;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/13 0013 9:40
 * 文章实体
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Article {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    private String title;

    // Markdown 正文内容
    private String mdContent;
    // 无语法格式正文内容 , 可用于全文检索
    private String contentNotFormat;
    //简介
    private String profile;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //主图
    private String mainPic;
    //有效性
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getContentNotFormat() {
        return contentNotFormat;
    }

    public void setContentNotFormat(String contentNotFormat) {
        this.contentNotFormat = contentNotFormat;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }
}
