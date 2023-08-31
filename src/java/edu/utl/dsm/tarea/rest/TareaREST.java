/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utl.dsm.tarea.rest;

import com.google.gson.Gson;
import edu.utl.dsm.tarea.controller.ControllerTarea;
import edu.utl.dsm.tarea.model.Tarea;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DANIELA
 */
@Path("Tarea")
public class TareaREST extends Application {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("estatus") String estatus) {
        String out = "";
        try {
            ControllerTarea objCs = new ControllerTarea();
            List<Tarea> tarea = new ArrayList<Tarea>();
            tarea = objCs.getall();
            Gson objGS = new Gson();
            out = objGS.toJson(tarea);
        } catch (Exception ex) {
            ex.printStackTrace();
            out = "{\"error\":\"Hubo un error al catalago de sucursales,vuelve a intentarlo, o llama al administrador del sistema\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    

    
    
    @Path("delete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@QueryParam("id") String id) {
        String out = "";
        try {
            ControllerTarea objCS = new ControllerTarea();
            objCS.delete(Integer.parseInt(id));
            out = "{\"result\":\"la eliminacion resultó exitosa\"}";
        } catch (Exception ex) {
            out = "{\"error\":\"Hubo un fallo al eliminar la sala,vuelve a intentarlo, o llama al administrador del sistema\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }


    @Path("insertarSala")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert( @QueryParam("desc") String des, @QueryParam("estado") String est) {
        String out = "";
        Tarea s = new Tarea();
        s.setDescripcion(des);
        s.setEstatus(est);
        try {
            ControllerTarea objCS = new ControllerTarea();
            //llamamos al metodo de insertar
            objCS.insert(s);
        } catch (Exception ex) {
            ex.printStackTrace();
            //en caso de algun error queneramos la respuest de error del servicio
            out = "{\"error\":\"Hubo un fallo al insertar los datos,vuelve a intentarlo, o llama al administrador del sistema\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("update")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@QueryParam("id") int id,@QueryParam("desc") String des, @QueryParam("estado") String est) {
      String out = "";
        Tarea s = new Tarea();
        s.setDescripcion(des);
        s.setEstatus(est);
        try {
            ControllerTarea objCS = new ControllerTarea();
            //llamamos al metodo de insertar
            objCS.update(id,s);
        } catch (Exception ex) {
            ex.printStackTrace();
            //en caso de algun error queneramos la respuest de error del servicio
            out = "{\"error\":\"Hubo un fallo al modificar los datos,vuelve a intentarlo, o llama al administrador del sistema\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    

   
  
    
    
}
