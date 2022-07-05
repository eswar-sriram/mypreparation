package com.project.mypreparation.repo;

import com.project.mypreparation.model.SubTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubTaskRepo extends JpaRepository<SubTasks,Long> {

    @Modifying
    @Query(value = "delete from subtasks where taskid=:id",nativeQuery = true)
    void deleteSubTaskByTaskId(long id);

    default void deleteByTaskId(long taskid){
        deleteSubTaskByTaskId(taskid);
    }
}
