/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.jsf.utils;
 
import com.alkanza.Role;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
 
@ManagedBean(name="roleConverter")
public class RoleConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                RoleServiceData service = (RoleServiceData) fc.getExternalContext().getSessionMap().get("roleServiceData");
                Role tmprole = new Role();
                for (Role role : service.getRoles()) {
                    if(Objects.equals(role.getIdrole(), Integer.parseInt(value))){
                        tmprole = role;
                    }
                }
                return tmprole;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid role."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Role) object).getIdrole());
        }
        else {
            return null;
        }
    }   
}         
