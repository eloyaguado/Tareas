package com.tasks.model.dto;

public class TaskDto {

    private Integer id;

    private String description;

    private Integer status;

    public TaskDto() {
    }

    public TaskDto(Integer id, String description, Integer status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public TaskDto(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
