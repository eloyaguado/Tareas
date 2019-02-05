package com.tasks.model.entity;

import javax.persistence.*;

@Entity
public class Task {

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column
    private String description;

    @Column
    private Integer status;

    public Task(String description, Integer status) {
        this.description = description;
        this.status = status;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer taskId) {
        this.id = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
