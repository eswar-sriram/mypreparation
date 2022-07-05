package com.project.mypreparation.repo;

import com.project.mypreparation.model.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDataRepo extends JpaRepository<UserTasks,Long> {
}
