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

    @Autowired
    private SubTaskService subTaskService;

    @Autowired
    private NotesService notesService;

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

    public Object deleteTask(String taskid){
        long id = Long.parseLong(taskid);
        try {
            subTaskService.deleteSubTaskByTaskId(id);
            notesService.deleteNotesByTaskId(id);
            taskDataRepo.deleteById(id);
        }catch (Exception e){
            return new GenericObject(-1,e.getLocalizedMessage());
        }
        return new GenericObject(1,"Deleted successfully");
    }
}
