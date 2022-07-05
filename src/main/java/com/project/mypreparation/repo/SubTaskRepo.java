package com.project.mypreparation.repo;

import com.project.mypreparation.model.SubTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepo extends JpaRepository<SubTasks,Long> {
}
