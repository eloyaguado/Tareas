package com.tasks.controller;

import com.tasks.model.dto.TaskDto;
import com.tasks.model.service.TaskService;
import com.tasks.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(Constants.GET_TASK_BY_ID)
    public TaskDto getTaskById(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @RequestMapping(Constants.GET_ALL_TASKS)
    public List< TaskDto > getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = Constants.SAVE_TASK, method = RequestMethod.POST)
    public void saveTask(@RequestBody TaskDto taskDto) {
        taskService.saveTask(taskDto);
    }

    @RequestMapping(value = Constants.UPDATE_TASKS, method = RequestMethod.POST)
    public void updateTask(@RequestBody TaskDto taskDto) {
        taskService.updateTask(taskDto);
    }

    @RequestMapping(value = Constants.DELETE_TASK, method = RequestMethod.POST)
    public void deleteTask(@RequestBody Integer taskId) {
        taskService.deleteTask(taskId);
    }
}
