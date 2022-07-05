package com.project.mypreparation.controller;

import com.project.mypreparation.model.Notes;
import com.project.mypreparation.model.SubTasks;
import com.project.mypreparation.model.UserTasks;
import com.project.mypreparation.service.NotesService;
import com.project.mypreparation.service.SubTaskService;
import com.project.mypreparation.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private SubTaskService subTaskService;
    @Autowired
    private NotesService notesService;

    @PostMapping("/addtask")
    public UserTasks addTaskToUser(@RequestBody UserTasks userTasks){
        return taskService.addTask(userTasks);
    }

    @GetMapping("/gettasks/{id}")
    public Object getTasksofUser(@PathVariable String id){
        return taskService.getTasksofUser(id);
    }


    @PostMapping("/addsubtask")
    public SubTasks addSubTask(@RequestBody SubTasks subTasks){
        return subTaskService.addSubTask(subTasks);
    }

    @GetMapping("/getsubtask/{userid}/{taskid}")
    public Object getSubTasks(@PathVariable String userid,@PathVariable String taskid){
        return subTaskService.getSubTasks(userid, taskid);
    }

    @PostMapping("/addnotes")
    public Notes addNotesAndLinks(@RequestBody Notes notes){
        return notesService.addNotes(notes);
    }

    @GetMapping("/getnotes/{userid}/{taskid}")
    public Object getNotesAndLinks(@PathVariable String userid,@PathVariable String taskid) {
        return notesService.getNotesAndLinks(userid, taskid);
    }
}
