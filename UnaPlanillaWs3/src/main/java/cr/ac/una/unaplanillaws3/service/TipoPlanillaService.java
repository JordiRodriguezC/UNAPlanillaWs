/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanillaws3.service;

import cr.ac.una.unaplanillaws3.model.Empleado;
import cr.ac.una.unaplanillaws3.model.EmpleadoDto;
import cr.ac.una.unaplanillaws3.model.TipoPlanillaDto;
import cr.ac.una.unaplanillaws3.model.Tipoplanilla;
import cr.ac.una.unaplanillaws3.util.CodigoRespuesta;
import cr.ac.una.unaplanillaws3.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Stateless
@LocalBean
public class TipoPlanillaService {
    private static final Logger LOG = Logger.getLogger(EmpleadoService.class.getName());

    @PersistenceContext(unitName = "UnaPlanillaWs2PU")
    private EntityManager em;

  

    public Respuesta guardarTipoPlanilla(TipoPlanillaDto tipoPlanillaDto){
        try {
            Tipoplanilla tipoPlanilla;
            if (tipoPlanillaDto.getTplaId() != null && tipoPlanillaDto.getTplaId() > 0) {
                tipoPlanilla = em.find(Tipoplanilla.class, tipoPlanillaDto.getTplaId());
                if (tipoPlanilla == null) {
                    return new Respuesta(false,CodigoRespuesta.ERROR_NOENCONTRADO ,"No se encontró el tipo de planilla a modificar.", "guardarTipoPlanilla NoResultException");
                }
                tipoPlanilla.actualizarTipoPlanilla(tipoPlanillaDto);
                for (EmpleadoDto emp : tipoPlanillaDto.getEmpleadosEliminados()) {
                    tipoPlanilla.getEmpleadoList().remove(new Empleado(emp.getEmpId()));
                }
                
                if (!tipoPlanillaDto.getEmpleados().isEmpty()) {
                    for (EmpleadoDto emp : tipoPlanillaDto.getEmpleados()) {
                        if (emp.getModificado()) {
                            Empleado empleado = em.find(Empleado.class, emp.getEmpId());
                            empleado.getTipoplanillaList().add(tipoPlanilla);
                            tipoPlanilla.getEmpleadoList().add(empleado);
                        }
                    }
                }
                
                tipoPlanilla = em.merge(tipoPlanilla);
            } else {
                tipoPlanilla = new Tipoplanilla(tipoPlanillaDto);
                em.persist(tipoPlanilla);
            }
            em.flush();
            return new Respuesta(true,CodigoRespuesta.CORRECTO ,"", "", "TipoPlanilla", new TipoPlanillaDto(tipoPlanilla));
        } catch (Exception ex) {
            Logger.getLogger(TipoPlanillaService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el tipo de planilla.", ex);
            return new Respuesta(false,CodigoRespuesta.ERROR_INTERNO ,"Ocurrio un error al guardar el tipo de planilla.", "guardarTipoPlanilla " + ex.getMessage());
        }
      
    }

    public Respuesta eliminarTipoPlanilla(Long id) {
       try {
            Tipoplanilla planilla;
            if (id != null && id > 0) {
                planilla = em.find(Tipoplanilla.class, id);
                if (planilla == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró la planilla a eliminar.", "eliminarPlanilla NoResultException");
                }
                em.remove(planilla);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "Debe cargar la planilla a eliminar.", "eliminarPlanilla NoResultException");
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No se puede eliminar la planilla porque tiene relaciones con otros registros.", "eliminarPlanilla " + ex.getMessage());
            }
            LOG.log(Level.SEVERE, "Ocurrio un error al eliminar.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al eliminar el empleado.", "eliminarEmpleado " + ex.getMessage());
        }
    }
    
    public Respuesta getPlanilla(Long id) {
        try {
            Query qryEmpleado = em.createNamedQuery("Tipoplanilla.findByTplaId", Tipoplanilla.class);
            qryEmpleado.setParameter("empId", id);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "TipoPlanilla", new TipoPlanillaDto((Tipoplanilla) qryEmpleado.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un empleado con el código ingresado.", "getEmpleado NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el empleado.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el empleado.", "getEmpleado " + ex.getMessage());
        }
    }

   
}
