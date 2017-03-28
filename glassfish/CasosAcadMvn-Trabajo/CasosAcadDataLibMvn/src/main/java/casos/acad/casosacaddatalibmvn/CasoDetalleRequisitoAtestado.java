/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.casosacaddatalibmvn;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omar
 */
@Entity
@Table(name = "caso_detalle_requisito_atestado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisitoAtestado.findAll", query = "SELECT c FROM CasoDetalleRequisitoAtestado c")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByIdCasoDetalleRequisitoAtestado", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.idCasoDetalleRequisitoAtestado = :idCasoDetalleRequisitoAtestado")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByNombre", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByUrl", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.url = :url")})
public class CasoDetalleRequisitoAtestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_detalle_requisito_atestado", nullable = false)
    private Integer idCasoDetalleRequisitoAtestado;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "url", length = 90)
    private String url;
    @JoinColumn(name = "id_caso_detalle_requisito", referencedColumnName = "id_caso_detalle_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CasoDetalleRequisito idCasoDetalleRequisito;

    public CasoDetalleRequisitoAtestado() {
    }

    public CasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public Integer getIdCasoDetalleRequisitoAtestado() {
        return idCasoDetalleRequisitoAtestado;
    }

    public void setIdCasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CasoDetalleRequisito getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(CasoDetalleRequisito idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisitoAtestado != null ? idCasoDetalleRequisitoAtestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisitoAtestado)) {
            return false;
        }
        CasoDetalleRequisitoAtestado other = (CasoDetalleRequisitoAtestado) object;
        if ((this.idCasoDetalleRequisitoAtestado == null && other.idCasoDetalleRequisitoAtestado != null) || (this.idCasoDetalleRequisitoAtestado != null && !this.idCasoDetalleRequisitoAtestado.equals(other.idCasoDetalleRequisitoAtestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "casos.acad.casosacaddatalibmvn.CasoDetalleRequisitoAtestado[ idCasoDetalleRequisitoAtestado=" + idCasoDetalleRequisitoAtestado + " ]";
    }
    
}
