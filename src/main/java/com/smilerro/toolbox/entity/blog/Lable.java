package com.smilerro.toolbox.entity.blog;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ：Skf
 * @date ：Created in 2019/11/15 0015 13:51
 * 标签实体
 */
@Entity
public class Lable {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lable() {
    }

    public Lable(String name) {
        this.name = name;
    }
}
