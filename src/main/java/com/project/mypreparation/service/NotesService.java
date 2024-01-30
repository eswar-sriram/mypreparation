package com.project.mypreparation.service;

import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.Notes;
import com.project.mypreparation.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepo notesRepo;

    public Notes addNotes(Notes notes){
        notes.setCreatedOn(new Date());
        return notesRepo.save(notes);
    }

    public Object getNotesAndLinks(String userId,String taskId,String subTaskId){
        long u_id= Long.parseLong(userId);
        long t_id= Long.parseLong(taskId);
        long st_id = Long.parseLong(subTaskId);
        System.out.println(u_id+""+t_id+""+st_id);
        List<Notes> temp = notesRepo.findAll();
        temp.removeIf(t->(t.getUserId()!=u_id || t.getTaskId()!=t_id) || t.getSubTaskId()!=st_id);
        if(temp.isEmpty()){
            Notes t = new Notes(null,u_id,t_id,st_id,"No Data",null,null);
            return new GenericObject(-1,"NO Data", List.of(t));
        }
        return temp;
    }

    public void deleteNotesByTaskId(long taskId) throws Exception{
        notesRepo.deleteNotesByTaskId(taskId);
    }

    public void deleteNotesBySubTaskId(long subTaskId) throws Exception{
        notesRepo.deleteNotesBySubTaskId(subTaskId);
    }
    //Added Comment
    
    public Object deleteNotesById(String notesId){
        long id = Long.parseLong(notesId);
        try {
            notesRepo.deleteById(id);
        }catch (Exception e){
            return new GenericObject(-1,this.getClass()+"-"+e.getLocalizedMessage());
        }
        return new GenericObject(1,"Notes has been deleted");
    }
}
