package com.tasks.model.service;

import com.tasks.model.dto.TaskDto;

import java.util.List;

public interface TaskService {

    /**
     * Devolvemos tarea por id
     * @param userId
     * @return
     */
    TaskDto getTaskById(Integer userId);

    /**
     * Guarda tarea
     * @param userDto
     */
    void saveTask(TaskDto userDto);

    /**
     * Actualiza tarea
     * @param userDto
     */
    void updateTask(TaskDto userDto);

    /**
     * Devuelve todas las tareas
     * @return
     */
    List< TaskDto > getAllTasks();

    /**
     * Borra tarea
     * @param userId
     */
    void deleteTask(Integer userId);
}
