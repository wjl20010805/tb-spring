package com.jk.entity;

import java.io.Serializable;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:39
 *
 */
public class TypeEntity implements Serializable {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
