/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.casosacaddatalibmvn;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author omar
 */
@Entity
@Table(name = "proceso_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDetalle.findAll", query = "SELECT p FROM ProcesoDetalle p")
    , @NamedQuery(name = "ProcesoDetalle.findByIdProcesoDetalle", query = "SELECT p FROM ProcesoDetalle p WHERE p.idProcesoDetalle = :idProcesoDetalle")
    , @NamedQuery(name = "ProcesoDetalle.findByDescripcion", query = "SELECT p FROM ProcesoDetalle p WHERE p.descripcion = :descripcion")})
public class ProcesoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proceso_detalle", nullable = false)
    private Integer idProcesoDetalle;
    @Column(name = "descripcion", length = 90)
    private String descripcion;
    @OneToMany(mappedBy = "idPadre", fetch = FetchType.EAGER)
    private List<ProcesoDetalle> procesoDetalleList;
    @JoinColumn(name = "id_padre", referencedColumnName = "id_proceso_detalle")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProcesoDetalle idPadre;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proceso idProceso;

    public ProcesoDetalle() {
    }

    public ProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public Integer getIdProcesoDetalle() {
        return idProcesoDetalle;
    }

    public void setIdProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<ProcesoDetalle> getProcesoDetalleList() {
        return procesoDetalleList;
    }

    public void setProcesoDetalleList(List<ProcesoDetalle> procesoDetalleList) {
        this.procesoDetalleList = procesoDetalleList;
    }

    public ProcesoDetalle getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(ProcesoDetalle idPadre) {
        this.idPadre = idPadre;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesoDetalle != null ? idProcesoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetalle)) {
            return false;
        }
        ProcesoDetalle other = (ProcesoDetalle) object;
        if ((this.idProcesoDetalle == null && other.idProcesoDetalle != null) || (this.idProcesoDetalle != null && !this.idProcesoDetalle.equals(other.idProcesoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "casos.acad.casosacaddatalibmvn.ProcesoDetalle[ idProcesoDetalle=" + idProcesoDetalle + " ]";
    }
    
}
