package com.project.mypreparation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericObject {
    private int status;
    private String message;
    private Object object;

    public GenericObject(int status, String message) {
        this.status = status;
        this.message = message;
    }


}
