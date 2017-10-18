/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.api;


import com.alkanza.ImgPreference;
import com.alkanza.ReturnOperation;
import com.alkanza.manager.PreferenceManager;
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
@Path(value = "/Preference")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class PreferenceService {

    @EJB
    PreferenceManager manager;

    @GET
    @Path("/findAll")
    public List<ImgPreference> findAll() {
        return manager.findAll();

    }

    @GET
    @Path("/find/{id}")
    public ImgPreference find(@PathParam("id") Long id) {
        return manager.findById(id);
    }

    @GET
    @Path("/findRange/{numRows}/{firstRow}")
    public List<ImgPreference> findRange(@PathParam("numRows") int numRows,
            @PathParam("firstRow") int firstRow) {
        return manager.findRange(numRows, firstRow);
    }

    @PUT
    @Path("/")
    public ReturnOperation edit(ImgPreference entity) {
        return manager.edit(entity);
    }

    @POST
    @Path("/")
    public ReturnOperation insert(ImgPreference entity) {
        return manager.save(entity);
    }

    @DELETE
    @Path("/")
    public ReturnOperation delete(ImgPreference entity) {
        return manager.delete(entity);
    }

}