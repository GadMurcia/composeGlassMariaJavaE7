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
@Table(name = "paso_requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasoRequisito.findAll", query = "SELECT p FROM PasoRequisito p")
    , @NamedQuery(name = "PasoRequisito.findByIdPasoRequisito", query = "SELECT p FROM PasoRequisito p WHERE p.idPasoRequisito = :idPasoRequisito")
    , @NamedQuery(name = "PasoRequisito.findByNombre", query = "SELECT p FROM PasoRequisito p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PasoRequisito.findByDescripcion", query = "SELECT p FROM PasoRequisito p WHERE p.descripcion = :descripcion")})
public class PasoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paso_requisito", nullable = false)
    private Integer idPasoRequisito;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @JoinColumn(name = "id_paso", referencedColumnName = "id_paso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paso idPaso;
    @JoinColumn(name = "id_requisito", referencedColumnName = "id_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Requisito idRequisito;

    public PasoRequisito() {
    }

    public PasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public Integer getIdPasoRequisito() {
        return idPasoRequisito;
    }

    public void setIdPasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Paso getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Paso idPaso) {
        this.idPaso = idPaso;
    }

    public Requisito getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Requisito idRequisito) {
        this.idRequisito = idRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasoRequisito != null ? idPasoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoRequisito)) {
            return false;
        }
        PasoRequisito other = (PasoRequisito) object;
        if ((this.idPasoRequisito == null && other.idPasoRequisito != null) || (this.idPasoRequisito != null && !this.idPasoRequisito.equals(other.idPasoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "casos.acad.casosacaddatalibmvn.PasoRequisito[ idPasoRequisito=" + idPasoRequisito + " ]";
    }
    
}
