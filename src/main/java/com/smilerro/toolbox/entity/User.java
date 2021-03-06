package com.smilerro.toolbox.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ：Skf
 * @date ：Created in 2019/10/25 0025 16:29
 */
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;
    private String username;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
