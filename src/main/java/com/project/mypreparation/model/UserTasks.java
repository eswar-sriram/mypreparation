package com.project.mypreparation.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usertasktable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private long taskId;

    @Column(name = "userid")
    private long userId;

    @Column(name = "taskname")
    private String taskName;

    @Column(name = "createdon")
    private Date createdOn;

}
