package com.project.mypreparation.service;

import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.SubTasks;
import com.project.mypreparation.repo.SubTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubTaskService {

    @Autowired
    private SubTaskRepo subTaskRepo;

    public Object getSubTasks(String userId,String taskId){
        long u_id= Long.parseLong(userId);
        long t_id= Long.parseLong(taskId);
        List<SubTasks> temp = subTaskRepo.findAll();
        temp.removeIf(t->(t.getUserId()!=u_id || t.getTaskId()!=t_id));
        if(temp.isEmpty())return new GenericObject(-1,"No Subtasks for task");
        return temp;
    }

    public SubTasks addSubTask(SubTasks subTasks){
        subTasks.setCreatedOn(new Date());
        return subTaskRepo.save(subTasks);
    }

    public void deleteSubTaskByTaskId(long taskId) throws Exception{
        subTaskRepo.deleteByTaskId(taskId);
    }

    public Object deleteSubTaskById(String subTaskId){
        long id = Long.parseLong(subTaskId);
        try {
            subTaskRepo.deleteById(id);
        }catch (Exception e){
            return new GenericObject(-1,this.getClass()+"---"+e.getLocalizedMessage());
        }
        return new GenericObject(1,"SubTask Deleted Successfully");
    }
}
