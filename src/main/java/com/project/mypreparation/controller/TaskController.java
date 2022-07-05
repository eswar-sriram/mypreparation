package com.project.mypreparation.controller;

import com.project.mypreparation.model.UserTasks;
import com.project.mypreparation.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addtask")
    public UserTasks addTaskToUser(@RequestBody UserTasks userTasks){
        return taskService.addTask(userTasks);
    }

    @GetMapping("/gettasks/{id}")
    public Object getTasksofUser(@PathVariable String id){
        return taskService.getTasksofUser(id);
    }
}
