package com.project.mypreparation.repo;

import com.project.mypreparation.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Long> {
}
