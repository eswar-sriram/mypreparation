package com.project.mypreparation.service;

import com.project.mypreparation.model.GenericObject;
import com.project.mypreparation.model.UserData;
import com.project.mypreparation.repo.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDataRepo userDataRepo;


    public GenericObject isUserThere(UserData userData){
        List<UserData> list = userDataRepo.findAll();
        for(UserData i : list){
            if(i.getUserName().equals(userData.getUserName())) {
                if (i.getPassword().equals(userData.getPassword())) {
                    return new GenericObject(1, "Success");
                }
                return new GenericObject(-1, "wrong password");
            }
        }
        return new GenericObject(-1,"Username is wrong/ user is not present");
    }

    public Object addUser(UserData userData){
        userData.setCreatedOn(new Date());
        UserData u = null;
        try{
            u=userDataRepo.save(userData);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new GenericObject(-1,e.getLocalizedMessage());
        }
        return u;
    }
}
