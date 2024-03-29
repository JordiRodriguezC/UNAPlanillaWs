/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanillaws3.controller;

import cr.ac.una.unaplanillaws3.model.EmpleadoDto;
import cr.ac.una.unaplanillaws3.model.TipoPlanillaDto;
import cr.ac.una.unaplanillaws3.service.TipoPlanillaService;
import cr.ac.una.unaplanillaws3.util.CodigoRespuesta;
import cr.ac.una.unaplanillaws3.util.Respuesta;
import cr.ac.una.unaplanillaws3.util.Secure;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author JORDI RODRIGUEZ
 */

@Path("/TipoPlanillaController")
public class TipoPlanillaController {
    @EJB
    TipoPlanillaService planillaService;
    
    
    @GET
    @Path("/planillas/{codigo}/{id}/{planillaPorMes}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpleados(@PathParam("codigo") String codigo, @PathParam("id") String id, @PathParam("planillaPorMes") String planillasPorMes) {
        try {
            Respuesta res = planillaService.getPlanillas(codigo, id, planillasPorMes);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            ArrayList<EmpleadoDto> empeladosDto = (ArrayList<EmpleadoDto>) res.getResultado("Empleados");
            
            return Response.ok(new GenericEntity<List<EmpleadoDto>>(empeladosDto){}).build();
        } catch (Exception ex) {
            Logger.getLogger(TipoPlanillaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo los empleados").build();
        }
    }
    
    @GET
    @Path("/planilla/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanilla(@PathParam("id") Long id) {
        try {
            Respuesta res = planillaService.getPlanilla(id);
            if (!res.getEstado()) {
                return Response.status(res.getCodigoRespuesta().getValue()).entity(res.getMensaje()).build();
            }
            return Response.ok((TipoPlanillaDto) res.getResultado("Planilla")).build();
        } catch (Exception ex) {
            Logger.getLogger(TipoPlanillaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error obteniendo la planilla").build();
        }
    }
    
    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarPlanilla(TipoPlanillaDto tipoPlanilla) {
        System.out.println("XD");
        try {
            Respuesta respuesta = planillaService.guardarTipoPlanilla(tipoPlanilla);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok((TipoPlanillaDto) respuesta.getResultado("Planilla")).build();
        } catch (Exception ex) {
            Logger.getLogger(TipoPlanillaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error guardando la Planilla").build();
        }
    }
    
    @DELETE
    @Path("/planilla/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarPlanilla(@PathParam("id") Long id) {
        try {
            Respuesta respuesta = planillaService.eliminarTipoPlanilla(id);
            if (!respuesta.getEstado()) {
                return Response.status(respuesta.getCodigoRespuesta().getValue()).entity(respuesta.getMensaje()).build();
            }
            return Response.ok().build();
        } catch (Exception ex) {
            Logger.getLogger(TipoPlanillaController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(CodigoRespuesta.ERROR_INTERNO.getValue()).entity("Error eliminando la planilla").build();
        }
    }
    
}
