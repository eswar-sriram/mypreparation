package com.project.mypreparation.service;

import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.Notes;
import com.project.mypreparation.repo.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Object getNotesAndLinks(String userId,String taskId){
        long u_id= Long.parseLong(userId);
        long t_id= Long.parseLong(taskId);
        List<Notes> temp = notesRepo.findAll();
        temp.removeIf(t->(t.getUserId()!=u_id || t.getTaskId()!=t_id));
        if(temp.isEmpty())return new GenericObject(-1,"No Notes");
        return temp;
    }

    public void deleteNotesByTaskId(long taskId) throws Exception{
        notesRepo.deleteNotesByTaskId(taskId);
    }

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
