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
@AllArgsConstructor
@Entity
@Table(name = "notesandlinks")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notesid")
    private long notesId;

    @Column(name = "userid")
    private long userId;

    @Column(name = "taskid")
    private long taskId;

    @Column(name = "notesdata")
    private String notesData;

    @Column(name = "noteslinks")
    private String notesLinks;

    @Column(name = "createdon")
    private Date createdOn;
}
