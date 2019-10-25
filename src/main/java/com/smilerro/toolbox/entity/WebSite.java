package com.smilerro.toolbox.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 13:57
 * 站点实体
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class WebSite {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 链接
     */
    private String link;
    /**
     * 简介
     */
    private String profile;
    /**
     * 图片
     */
    private String pic;
    /**
     * 状态
     */
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
