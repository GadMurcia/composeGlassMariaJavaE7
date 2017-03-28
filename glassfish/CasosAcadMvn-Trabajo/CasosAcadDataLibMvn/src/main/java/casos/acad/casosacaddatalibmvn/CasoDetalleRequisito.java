/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.casosacaddatalibmvn;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "caso_detalle_requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisito.findAll", query = "SELECT c FROM CasoDetalleRequisito c")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdCasoDetalleRequisito", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.idCasoDetalleRequisito = :idCasoDetalleRequisito")
    , @NamedQuery(name = "CasoDetalleRequisito.findByDescripcion", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.descripcion = :descripcion")})
public class CasoDetalleRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_detalle_requisito", nullable = false)
    private Integer idCasoDetalleRequisito;
    @Column(name = "descripcion", length = 90)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoDetalleRequisito", fetch = FetchType.EAGER)
    private List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList;
    @JoinColumn(name = "id_caso_detalle", referencedColumnName = "id_caso_detalle", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CasoDetalle idCasoDetalle;

    public CasoDetalleRequisito() {
    }

    public CasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public Integer getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CasoDetalleRequisitoAtestado> getCasoDetalleRequisitoAtestadoList() {
        return casoDetalleRequisitoAtestadoList;
    }

    public void setCasoDetalleRequisitoAtestadoList(List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList) {
        this.casoDetalleRequisitoAtestadoList = casoDetalleRequisitoAtestadoList;
    }

    public CasoDetalle getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(CasoDetalle idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisito != null ? idCasoDetalleRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisito)) {
            return false;
        }
        CasoDetalleRequisito other = (CasoDetalleRequisito) object;
        if ((this.idCasoDetalleRequisito == null && other.idCasoDetalleRequisito != null) || (this.idCasoDetalleRequisito != null && !this.idCasoDetalleRequisito.equals(other.idCasoDetalleRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "casos.acad.casosacaddatalibmvn.CasoDetalleRequisito[ idCasoDetalleRequisito=" + idCasoDetalleRequisito + " ]";
    }
    
}
