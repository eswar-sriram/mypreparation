package com.project.mypreparation.repo;

import com.project.mypreparation.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NotesRepo extends JpaRepository<Notes,Long> {

    @Query(value = "delete from notesandlinks where taskid=:id",nativeQuery = true)
    @Modifying
    void deleteNotes(long id);

    default void deleteNotesByTaskId(long taskid){
        deleteNotes(taskid);
    }
}
