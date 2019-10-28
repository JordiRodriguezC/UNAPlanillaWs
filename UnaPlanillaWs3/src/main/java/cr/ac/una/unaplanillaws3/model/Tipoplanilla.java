/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaplanillaws3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Entity
@Table(name = "PLAM_TIPOPLANILLAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoplanilla.findAll", query = "SELECT t FROM Tipoplanilla t")
    , @NamedQuery(name = "Tipoplanilla.findByTplaId", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaId = :tplaId")
    , @NamedQuery(name = "Tipoplanilla.findByTplaCodigo", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaCodigo = :tplaCodigo")
    , @NamedQuery(name = "Tipoplanilla.findByTplaDescripcion", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaDescripcion = :tplaDescripcion")
    , @NamedQuery(name = "Tipoplanilla.findByTplaPlaxmes", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaPlaxmes = :tplaPlaxmes")
    , @NamedQuery(name = "Tipoplanilla.findByTplaAnoultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaAnoultpla = :tplaAnoultpla")
    , @NamedQuery(name = "Tipoplanilla.findByTplaMesultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaMesultpla = :tplaMesultpla")
    , @NamedQuery(name = "Tipoplanilla.findByTplaNumultpla", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaNumultpla = :tplaNumultpla")
    , @NamedQuery(name = "Tipoplanilla.findByTplaEstado", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaEstado = :tplaEstado")
    , @NamedQuery(name = "Tipoplanilla.findByTplaVersion", query = "SELECT t FROM Tipoplanilla t WHERE t.tplaVersion = :tplaVersion")})
public class Tipoplanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "PLAM_PLANILLAS_EMP_ID_GENERATOR", sequenceName = "UNA.PLAM_TIPOPLANILLAS_SEC01", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAM_PLANILLAS_EMP_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "TPLA_ID")
    private Long tplaId;
    @Basic(optional = false)
    @Column(name = "TPLA_CODIGO")
    private String tplaCodigo;
    @Basic(optional = false)
    @Column(name = "TPLA_DESCRIPCION")
    private String tplaDescripcion;
    @Basic(optional = false)
    @Column(name = "TPLA_PLAXMES")
    private Integer tplaPlaxmes;
    @Column(name = "TPLA_ANOULTPLA")
    private Integer tplaAnoultpla;
    @Column(name = "TPLA_MESULTPLA")
    private Integer tplaMesultpla;
    @Column(name = "TPLA_NUMULTPLA")
    private Integer tplaNumultpla;
    @Basic(optional = false)
    @Column(name = "TPLA_ESTADO")
    private String tplaEstado;
    @Basic(optional = false)
    @Column(name = "TPLA_VERSION")
    private Long tplaVersion;
    @JoinTable(name = "PLAM_EMPLEADOSPLANILLA", joinColumns = {
        @JoinColumn(name = "EXP_IDTPLA", referencedColumnName = "TPLA_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "EXP_IDEMP", referencedColumnName = "EMP_ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Tipoplanilla() {
    }

    public Tipoplanilla(Long tplaId) {
        this.tplaId = tplaId;
    }

    public Tipoplanilla(TipoPlanillaDto tipoPlanillaDto) {
        this.tplaId = tipoPlanillaDto.getTplaId();
        actualizarTipoPlanilla(tipoPlanillaDto);
    }

    public void actualizarTipoPlanilla(TipoPlanillaDto tipoPlanillaDto) {
        this.tplaCodigo = tipoPlanillaDto.getTplaCodigo();
        this.tplaDescripcion = tipoPlanillaDto.getTplaDescripcion();
        this.tplaEstado = tipoPlanillaDto.getTplaEstado();
        this.tplaVersion = tipoPlanillaDto.getTplaVersion();
        this.tplaAnoultpla = tipoPlanillaDto.getTplaAnoultpla();
        this.tplaNumultpla = tipoPlanillaDto.getTplaNumultpla();
        this.tplaMesultpla = tipoPlanillaDto.getTplaMesultpla();
        this.tplaPlaxmes = tipoPlanillaDto.getTplaPlaxmes();
       
    }

    public Tipoplanilla(Long tplaId, String tplaCodigo, String tplaDescripcion, Integer tplaPlaxmes, String tplaEstado, Long tplaVersion) {
        this.tplaId = tplaId;
        this.tplaCodigo = tplaCodigo;
        this.tplaDescripcion = tplaDescripcion;
        this.tplaPlaxmes = tplaPlaxmes;
        this.tplaEstado = tplaEstado;
        this.tplaVersion = tplaVersion;
    }

    public Long getTplaId() {
        return tplaId;
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
        return tplaPlaxmes;
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

    public Long getTplaVersion() {
        return tplaVersion;
    }

    public void setTplaVersion(Long tplaVersion) {
        this.tplaVersion = tplaVersion;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tplaId != null ? tplaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoplanilla)) {
            return false;
        }
        Tipoplanilla other = (Tipoplanilla) object;
        if ((this.tplaId == null && other.tplaId != null) || (this.tplaId != null && !this.tplaId.equals(other.tplaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.unaplanillaws3.model.Tipoplanilla[ tplaId=" + tplaId + " ]";
    }

}
