/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcanza.beans;

import com.alkanza.User;
import com.alkanza.jsf.utils.UserServiceData;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 *
 * @author oscar
 */
@ManagedBean(name="managementBean")
@ViewScoped
public class ManagementBean implements Serializable{

    private String imgOption1;
    private String imgOption2;
    private User localuser;
    
    @ManagedProperty("#{userServiceData}")
    private UserServiceData service;
    
    
    /**
     * Creates a new instance of ManagementBean
     */
    public ManagementBean() {
        loadRandomImages();
    }
    
     
    public List<User> completeUser(String query) {
        List<User> allUsers = service.getUsers();
        List<User> filteredUsers = new ArrayList<User>();
         
        for (int i = 0; i < allUsers.size(); i++) {
            User skin = allUsers.get(i);
            if(skin.getName().toLowerCase().startsWith(query)) {
                filteredUsers.add(skin);
            }
        }
         
        return filteredUsers;
    }

    public void loadRandomImages(){
        try {
            ClientConfig config = new DefaultClientConfig();
            config.getClasses().add(JacksonJaxbJsonProvider.class);
            config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            
            Client client = Client.create(config);

            WebResource webResource = client.resource("http://www.splashbase.co/api/v1/images/random");

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
               throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
            }

            HashMap<String,String> output = response.getEntity(new GenericType<HashMap<String,String>>(){});

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void eventOption1(){
        System.out.println("Entro al evento de la opcion1");
        loadRandomImages();
    }
    
    public void eventOption2(){
        System.out.println("Entro al evento de la opcion2");
        loadRandomImages();
    }

    public String getImgOption1() {
        return imgOption1;
    }

    public void setImgOption1(String imgOption1) {
        this.imgOption1 = imgOption1;
    }

    public String getImgOption2() {
        return imgOption2;
    }

    public void setImgOption2(String imgOption2) {
        this.imgOption2 = imgOption2;
    }

    public User getLocaluser() {
        return localuser;
    }

    public void setLocaluser(User localuser) {
        this.localuser = localuser;
    }

    public UserServiceData getService() {
        return service;
    }

    public void setService(UserServiceData service) {
        this.service = service;
    }
    
    
    
}
