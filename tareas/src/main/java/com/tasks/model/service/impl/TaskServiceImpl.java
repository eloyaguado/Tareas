package com.tasks.model.service.impl;

import com.tasks.model.dto.TaskDto;
import com.tasks.model.repository.TaskRepository;
import com.tasks.model.service.TaskService;
import com.tasks.utils.TaskUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDto getTaskById(Integer id) {
        return TaskUtils.entityToDto(taskRepository.getOne(id));
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        taskRepository.save(TaskUtils.dtoToEntity(taskDto));
    }

    @Override
    public void updateTask(TaskDto taskDto) {
        taskRepository.save(TaskUtils.dtoToEntity(taskDto));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<TaskDto> taskList = taskRepository.findAll().stream().map(TaskUtils::entityToDto)
                .collect(Collectors.toList());
        return taskList;
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.delete(taskRepository.getOne(id));
    }
}
