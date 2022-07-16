package com.project.mypreparation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notesandlinks")
public class Notes {

    public Notes(long notesId, long userId, long taskId, long subTaskId, String notesData, String notesLinks, Date createdOn) {
        this.notesId = notesId;
        this.userId = userId;
        this.taskId = taskId;
        this.subTaskId = subTaskId;
        this.notesData = notesData;
        this.notesLinks = notesLinks;
        this.createdOn = createdOn;
    }

    public Notes(String dummy, long userId, long taskId, long subTaskId, String notesData, String notesLinks, Date createdOn) {
        this.dummy = dummy;
        this.userId = userId;
        this.taskId = taskId;
        this.subTaskId = subTaskId;
        this.notesData = notesData;
        this.notesLinks = notesLinks;
        this.createdOn = createdOn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notesid")
    private long notesId;


    private String dummy;


    @Column(name = "userid")
    private long userId;

    @Column(name = "taskid")
    private long taskId;

    @Column(name = "subtaskid")
    private long subTaskId;

    @Column(name = "notesdata")
    private String notesData;

    @Column(name = "noteslinks")
    private String notesLinks;

    @Column(name = "createdon")
    private Date createdOn;
}
