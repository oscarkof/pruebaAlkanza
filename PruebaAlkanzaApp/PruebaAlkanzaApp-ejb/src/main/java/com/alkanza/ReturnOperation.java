/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ivanpena
 */
public class ReturnOperation implements Serializable {
    
    String code;
    Object message;
    Long timeExecute;

    public ReturnOperation(String code, String message, Long timeExecute) {
        this.code = code;
        this.message = message;
        this.timeExecute = timeExecute;
    }

    public ReturnOperation() {
        this.code = "OK";
        timeExecute = new Date().getTime();
        this.message = "SUCCESSFUL";

    
    }
    
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Long getTimeExecute() {
        return timeExecute;
    }

    public void setTimeExecute(Long timeExecute) {
        this.timeExecute = timeExecute;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
    
    
}
