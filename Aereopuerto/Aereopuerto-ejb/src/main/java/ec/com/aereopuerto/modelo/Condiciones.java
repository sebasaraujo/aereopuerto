/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "condiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condiciones.findAll", query = "SELECT c FROM Condiciones c")
    , @NamedQuery(name = "Condiciones.findByCodigoCo", query = "SELECT c FROM Condiciones c WHERE c.codigoCo = :codigoCo")
    , @NamedQuery(name = "Condiciones.findByNombreCo", query = "SELECT c FROM Condiciones c WHERE c.nombreCo = :nombreCo")
    , @NamedQuery(name = "Condiciones.findByEstadoCo", query = "SELECT c FROM Condiciones c WHERE c.estadoCo = :estadoCo")
    , @NamedQuery(name = "Condiciones.findByUsuarioActCo", query = "SELECT c FROM Condiciones c WHERE c.usuarioActCo = :usuarioActCo")
    , @NamedQuery(name = "Condiciones.findByFechaActCo", query = "SELECT c FROM Condiciones c WHERE c.fechaActCo = :fechaActCo")})
public class Condiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_co")
    private Integer codigoCo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_co")
    private String nombreCo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_co")
    private String estadoCo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_co")
    private int usuarioActCo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_co")
    @Temporal(TemporalType.DATE)
    private Date fechaActCo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "condicion")
    private List<TarifaCondiciones> tarifaCondicionesList;

    public Condiciones() {
    }

    public Condiciones(Integer codigoCo) {
        this.codigoCo = codigoCo;
    }

    public Condiciones(Integer codigoCo, String nombreCo, String estadoCo, int usuarioActCo, Date fechaActCo) {
        this.codigoCo = codigoCo;
        this.nombreCo = nombreCo;
        this.estadoCo = estadoCo;
        this.usuarioActCo = usuarioActCo;
        this.fechaActCo = fechaActCo;
    }

    public Integer getCodigoCo() {
        return codigoCo;
    }

    public void setCodigoCo(Integer codigoCo) {
        this.codigoCo = codigoCo;
    }

    public String getNombreCo() {
        return nombreCo;
    }

    public void setNombreCo(String nombreCo) {
        this.nombreCo = nombreCo;
    }

    public String getEstadoCo() {
        return estadoCo;
    }

    public void setEstadoCo(String estadoCo) {
        this.estadoCo = estadoCo;
    }

    public int getUsuarioActCo() {
        return usuarioActCo;
    }

    public void setUsuarioActCo(int usuarioActCo) {
        this.usuarioActCo = usuarioActCo;
    }

    public Date getFechaActCo() {
        return fechaActCo;
    }

    public void setFechaActCo(Date fechaActCo) {
        this.fechaActCo = fechaActCo;
    }

    @XmlTransient
    public List<TarifaCondiciones> getTarifaCondicionesList() {
        return tarifaCondicionesList;
    }

    public void setTarifaCondicionesList(List<TarifaCondiciones> tarifaCondicionesList) {
        this.tarifaCondicionesList = tarifaCondicionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCo != null ? codigoCo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condiciones)) {
            return false;
        }
        Condiciones other = (Condiciones) object;
        if ((this.codigoCo == null && other.codigoCo != null) || (this.codigoCo != null && !this.codigoCo.equals(other.codigoCo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Condiciones[ codigoCo=" + codigoCo + " ]";
    }
    
}
