/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.api;


import com.alkanza.ReturnOperation;
import com.alkanza.User;
import com.alkanza.manager.UserManager;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author draico
 */

@Stateless
@Path(value = "/User")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class UserService {

    @EJB
    UserManager manager;

    @GET
    @Path("/findAll")
    public List<User> findAll() {
        return manager.findAll();

    }

    @GET
    @Path("/find/{id}")
    public User find(@PathParam("id") Long id) {
        return manager.findById(id);
    }

    @GET
    @Path("/findRange/{numRows}/{firstRow}")
    public List<User> findRange(@PathParam("numRows") int numRows,
            @PathParam("firstRow") int firstRow) {
        return manager.findRange(numRows, firstRow);
    }

    @PUT
    @Path("/")
    public ReturnOperation edit(User entity) {
        return manager.edit(entity);
    }

    @POST
    @Path("/")
    public ReturnOperation insert(User entity) {
        return manager.save(entity);
    }

    @DELETE
    @Path("/")
    public ReturnOperation delete(User entity) {
        return manager.delete(entity);
    }

}