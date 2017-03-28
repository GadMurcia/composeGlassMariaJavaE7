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
@Table(name = "paso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paso.findAll", query = "SELECT p FROM Paso p")
    , @NamedQuery(name = "Paso.findByIdPaso", query = "SELECT p FROM Paso p WHERE p.idPaso = :idPaso")
    , @NamedQuery(name = "Paso.findByNombre", query = "SELECT p FROM Paso p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paso.findByDescripcion", query = "SELECT p FROM Paso p WHERE p.descripcion = :descripcion")})
public class Paso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paso", nullable = false)
    private Integer idPaso;
    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "descripcion", length = 90)
    private String descripcion;
    @JoinColumn(name = "id_tipo_paso", referencedColumnName = "id_tipo_paso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoPaso idTipoPaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaso", fetch = FetchType.EAGER)
    private List<PasoRequisito> pasoRequisitoList;

    public Paso() {
    }

    public Paso(Integer idPaso) {
        this.idPaso = idPaso;
    }

    public Integer getIdPaso() {
        return idPaso;
    }

    public void setIdPaso(Integer idPaso) {
        this.idPaso = idPaso;
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

    public TipoPaso getIdTipoPaso() {
        return idTipoPaso;
    }

    public void setIdTipoPaso(TipoPaso idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    @XmlTransient
    public List<PasoRequisito> getPasoRequisitoList() {
        return pasoRequisitoList;
    }

    public void setPasoRequisitoList(List<PasoRequisito> pasoRequisitoList) {
        this.pasoRequisitoList = pasoRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaso != null ? idPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paso)) {
            return false;
        }
        Paso other = (Paso) object;
        if ((this.idPaso == null && other.idPaso != null) || (this.idPaso != null && !this.idPaso.equals(other.idPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "casos.acad.casosacaddatalibmvn.Paso[ idPaso=" + idPaso + " ]";
    }
    
}
