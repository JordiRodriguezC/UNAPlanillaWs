/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanillaws3.model;

/**
 *
 * @author JORDI RODRIGUEZ
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cbcar
 */
@XmlRootElement(name = "TipoPlanillaDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoPlanillaDto {

    private Long tplaId;
    public String tplaCodigo;
    public String tplaDescripcion;
    public Integer tplaPlaxmes;
    private Integer tplaAnoultpla;
    private Integer tplaMesultpla;
    private Integer tplaNumultpla;
    public String tplaEstado;
    private Boolean modificado;
    private Long tplaVersion;
    ObservableList<EmpleadoDto> empleados;
    List<EmpleadoDto> empleadosEliminados;
    
    
  /*  public SimpleStringProperty tplaId;
    public SimpleStringProperty tplaCodigo;
    public SimpleStringProperty tplaDescripcion;
    public SimpleStringProperty tplaPlaxmes;
    private Integer tplaAnoultpla;
    private Integer tplaMesultpla;
    private Integer tplaNumultpla;
    public SimpleBooleanProperty tplaEstado;
    private Boolean modificado;
    private Long tplaVersion;
    ObservableList<EmpleadoDto> empleados;
    List<EmpleadoDto> empleadosEliminados;*/


   
    public TipoPlanillaDto(Tipoplanilla tipoPlanilla) {
        this.tplaId = tipoPlanilla.getTplaId();
        this.tplaCodigo = tipoPlanilla.getTplaCodigo();
        this.tplaDescripcion = tipoPlanilla.getTplaDescripcion();
        this.tplaPlaxmes = tipoPlanilla.getTplaPlaxmes();
        this.tplaAnoultpla = tipoPlanilla.getTplaAnoultpla();
        this.tplaMesultpla = tipoPlanilla.getTplaPlaxmes();
        this.tplaNumultpla = tipoPlanilla.getTplaNumultpla();
        this.tplaEstado = tipoPlanilla.getTplaEstado();
        this.empleados = FXCollections.observableList(new ArrayList());
        this.empleadosEliminados = new ArrayList();
        this.tplaVersion = tipoPlanilla.getTplaVersion();
    }
    public Long getTplaId() {
        return this.tplaId;
    }

    public void setTplaId(Long tplaId) {
        this.tplaId = tplaId;
    }

    public String getTplaCodigo() {
        return tplaCodigo;
    }

    public void setTplaCodigo(String tplaCodigo) {
        this.tplaCodigo = tplaCodigo;
    }

    public String getTplaDescripcion() {
        return tplaDescripcion;
    }

    public void setTplaDescripcion(String tplaDescripcion) {
        this.tplaDescripcion = tplaDescripcion;
    }

    public Integer getTplaPlaxmes() {
       return this.tplaPlaxmes;
    }

    public void setTplaPlaxmes(Integer tplaPlaxmes) {
        this.tplaPlaxmes = tplaPlaxmes;
    }

    public Integer getTplaAnoultpla() {
        return tplaAnoultpla;
    }

    public void setTplaAnoultpla(Integer tplaAnoultpla) {
        this.tplaAnoultpla = tplaAnoultpla;
    }

    public Integer getTplaMesultpla() {
        return tplaMesultpla;
    }

    public void setTplaMesultpla(Integer tplaMesultpla) {
        this.tplaMesultpla = tplaMesultpla;
    }

    public Integer getTplaNumultpla() {
        return tplaNumultpla;
    }

    public void setTplaNumultpla(Integer tplaNumultpla) {
        this.tplaNumultpla = tplaNumultpla;
    }

    public String getTplaEstado() {
        return tplaEstado;
    }

    public void setTplaEstado(String tplaEstado) {
        this.tplaEstado = tplaEstado;
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    public ObservableList<EmpleadoDto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ObservableList<EmpleadoDto> empleados) {
        this.empleados = empleados;
    }

    public List<EmpleadoDto> getEmpleadosEliminados() {
        return empleadosEliminados;
    }

    public void setEmpleadosEliminados(List<EmpleadoDto> empleadosEliminados) {
        this.empleadosEliminados = empleadosEliminados;
    }

    public Long getTplaVersion() {
        return tplaVersion;
    }

    public void setTplaVersion(Long tplaVersion) {
        this.tplaVersion = tplaVersion;
    }
    
    
    
    @Override
    public String toString() {
        return "TipoPlanillaDto{" + "tplaId=" + tplaId + ", tplaCodigo=" + tplaCodigo + ", tplaDescripcion=" + tplaDescripcion + ", tplaPlaxmes=" + tplaPlaxmes + ", tplaAnoultpla=" + tplaAnoultpla + ", tplaMesultpla=" + tplaMesultpla + ", tplaNumultpla=" + tplaNumultpla + ", tplaEstado=" + tplaEstado + ", modificado=" + modificado + ", empleados=" + empleados + ", empleadosEliminados=" + empleadosEliminados + '}';
    }

   
}
