/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.jsf.utils;
import com.alkanza.Role;
import com.alkanza.manager.RoleManager;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="roleServiceData")
@SessionScoped
public class RoleServiceData implements Serializable{
     
    private List<Role>roles;
    @EJB
    RoleManager roleManager;

    public RoleServiceData() {
    }
    
    @PostConstruct
    public void init() {
        roles = roleManager.findAll();
    }
     
    public List<Role> getRoles() {
        return roles;
    } 
}
