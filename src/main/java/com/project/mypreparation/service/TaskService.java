package com.project.mypreparation.service;

import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.UserTasks;
import com.project.mypreparation.repo.TaskDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskDataRepo taskDataRepo;

    public UserTasks addTask(UserTasks userTasks){
        userTasks.setCreatedOn(new Date());
        return taskDataRepo.save(userTasks);
    }

    public Object getTasksofUser(String id){
        long id1= Long.parseLong(id);
        List<UserTasks> temp = taskDataRepo.findAll();
        temp.removeIf(t -> id1 != t.getUserId());
        if(temp.isEmpty())return new GenericObject(-1, "NO Tasks for the user");
        return temp;
    }
}
