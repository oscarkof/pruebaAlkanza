/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcanza.beans;

import com.alkanza.ReturnOperation;
import com.alkanza.Role;
import com.alkanza.User;
import com.alkanza.jsf.utils.RoleServiceData;
import com.alkanza.manager.RoleManager;
import com.alkanza.manager.UserManager;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author oscar
 */
@ManagedBean(name="userBean")
@ViewScoped
public class UserBean implements Serializable{
    
    User newUser;
    List<Role> roles;
    RoleManager roleManager;
    
    @ManagedProperty("#{roleServiceData}")
    private RoleServiceData roleServiceData;
    
    @EJB
    private UserManager um;

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
        newUser = new User();
        roleManager = new RoleManager();
    }

    @PostConstruct
    public void init(){
        loadRoles();
    }
    
    public void loadRoles(){
        try {
            this.roles = roleServiceData.getRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actionEvent(){
        try {
            System.out.println("obj: "+newUser);
            ReturnOperation ret = um.save(newUser);
            FacesContext.getCurrentInstance().addMessage("gralGrowl", new FacesMessage(FacesMessage.SEVERITY_INFO ,"User added successfully!",""));
            newUser = new User();
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("gralGrowl", new FacesMessage(FacesMessage.SEVERITY_ERROR ,"Error saving User!",""));        
        }
    }
    
    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public RoleManager getRoleManager() {
        return roleManager;
    }

    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public RoleServiceData getRoleServiceData() {
        return roleServiceData;
    }

    public void setRoleServiceData(RoleServiceData roleServiceData) {
        this.roleServiceData = roleServiceData;
    }

    
    
    
}
