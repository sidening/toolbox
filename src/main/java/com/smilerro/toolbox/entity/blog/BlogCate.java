package com.smilerro.toolbox.entity.blog;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/13 0013 9:40
 * 文章分类实体
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class BlogCate {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

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

    private String title;


}
