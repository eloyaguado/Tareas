package com.tasks.utils;

import com.tasks.model.dto.TaskDto;
import com.tasks.model.entity.Task;

public class TaskUtils {

    public static Task dtoToEntity(TaskDto taskDto) {
        Task task = new Task(taskDto.getDescription(), taskDto.getStatus());
        if (taskDto.getStatus() == null){
            task.setStatus(Constants.ID_STATUS_PORTFOLIO);
        }
        task.setId(taskDto.getId());
        return task;
    }
    public static TaskDto entityToDto(Task task) {
        TaskDto taskDto = new TaskDto(task.getId(), task.getDescription(),task.getStatus());
        return taskDto;
    }
}
