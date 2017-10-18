/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.jsf.utils;
 
import com.alkanza.Role;
import com.alkanza.User;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
 
@ManagedBean(name="userConverter")
public class UserConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                UserServiceData service = (UserServiceData) fc.getExternalContext().getSessionMap().get("userServiceData");
                User tmprole = new User();
                for (User userIt : service.getUsers()) {
                    if(Objects.equals(userIt.getIdrole(), Integer.parseInt(value))){
                        tmprole = userIt;
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
            return String.valueOf(((User) object).getIduser());
        }
        else {
            return null;
        }
    }   
}         
