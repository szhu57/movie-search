/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Moviedb;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author szhu
 */
@Stateless
@Path("entity.moviedb")
public class MoviedbFacadeREST extends AbstractFacade<Moviedb> {
    @PersistenceContext(unitName = "MovieSearchPU")
    private EntityManager em;

    public MoviedbFacadeREST() {
        super(Moviedb.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Moviedb entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Moviedb entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Moviedb find(@PathParam("id") Integer id) {
      
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Moviedb> findAll() {
        return super.findAll();
    }
    
    /*
    implement the  local restful service API for the JerseyClient to invoke 
    
    */
    @GET
    @Path("title/{title}")
    @Produces({"application/json"})
    public Moviedb find(@PathParam("title") String title) {
        int id =0;
        for (Moviedb m : super.findAll()) {
            if (m.getTitle().equalsIgnoreCase(title.trim())) {
                id = m.getMovieid();System.out.println(m.getTitle());
            }
            // System.out.println(m.getTitle()+"test--------------------->"+id+title);
        }
        System.out.println("test--------------------->"+id);
        return super.find(id);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Moviedb> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}