package com.smilerro.toolbox.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 16:53
 * 分类
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Gate {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    private String name;


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
}
