package com.project.mypreparation.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "subtasks")
@NoArgsConstructor
public class SubTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtaskid")
    private long subTaskId;

    @Column(name = "userid")
    private long userId;

    @Column(name = "taskid")
    private long taskId;

    @Column(name = "subtaskname")
    private String subTaskName;

    @Column(name = "subtaskdeadline")
    private String subTaskDeadLine;

    @Column(name = "createdon")
    private Date createdOn;
}
