/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.jsf.utils;
import com.alkanza.Role;
import com.alkanza.User;
import com.alkanza.manager.UserManager;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="userServiceData")
@SessionScoped
public class UserServiceData implements Serializable{
     
    private List<User>users;
    
    @EJB
    UserManager userManager;

    public UserServiceData() {
    }
    
    @PostConstruct
    public void init() {
        users = userManager.findAll();
    }
     
    public List<User> getUsers() {
        return users;
    } 
}
