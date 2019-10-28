package com.smilerro.toolbox.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/28 0028 9:30
 * 二级分类
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Category {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    private String name;
    @ManyToOne
    private Gate gate;

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

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
