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
@Table(name = "tipo_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContacto.findAll", query = "SELECT t FROM TipoContacto t")
    , @NamedQuery(name = "TipoContacto.findByCodigoTc", query = "SELECT t FROM TipoContacto t WHERE t.codigoTc = :codigoTc")
    , @NamedQuery(name = "TipoContacto.findByNombreTc", query = "SELECT t FROM TipoContacto t WHERE t.nombreTc = :nombreTc")
    , @NamedQuery(name = "TipoContacto.findByEstadoTc", query = "SELECT t FROM TipoContacto t WHERE t.estadoTc = :estadoTc")
    , @NamedQuery(name = "TipoContacto.findByUsuarioActTp", query = "SELECT t FROM TipoContacto t WHERE t.usuarioActTp = :usuarioActTp")
    , @NamedQuery(name = "TipoContacto.findByFechaActTp", query = "SELECT t FROM TipoContacto t WHERE t.fechaActTp = :fechaActTp")})
public class TipoContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tc")
    private Integer codigoTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_tc")
    private String nombreTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tc")
    private String estadoTc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tp")
    private int usuarioActTp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tp")
    @Temporal(TemporalType.DATE)
    private Date fechaActTp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContacto")
    private List<ContactoPasajero> contactoPasajeroList;

    public TipoContacto() {
    }

    public TipoContacto(Integer codigoTc) {
        this.codigoTc = codigoTc;
    }

    public TipoContacto(Integer codigoTc, String nombreTc, String estadoTc, int usuarioActTp, Date fechaActTp) {
        this.codigoTc = codigoTc;
        this.nombreTc = nombreTc;
        this.estadoTc = estadoTc;
        this.usuarioActTp = usuarioActTp;
        this.fechaActTp = fechaActTp;
    }

    public Integer getCodigoTc() {
        return codigoTc;
    }

    public void setCodigoTc(Integer codigoTc) {
        this.codigoTc = codigoTc;
    }

    public String getNombreTc() {
        return nombreTc;
    }

    public void setNombreTc(String nombreTc) {
        this.nombreTc = nombreTc;
    }

    public String getEstadoTc() {
        return estadoTc;
    }

    public void setEstadoTc(String estadoTc) {
        this.estadoTc = estadoTc;
    }

    public int getUsuarioActTp() {
        return usuarioActTp;
    }

    public void setUsuarioActTp(int usuarioActTp) {
        this.usuarioActTp = usuarioActTp;
    }

    public Date getFechaActTp() {
        return fechaActTp;
    }

    public void setFechaActTp(Date fechaActTp) {
        this.fechaActTp = fechaActTp;
    }

    @XmlTransient
    public List<ContactoPasajero> getContactoPasajeroList() {
        return contactoPasajeroList;
    }

    public void setContactoPasajeroList(List<ContactoPasajero> contactoPasajeroList) {
        this.contactoPasajeroList = contactoPasajeroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTc != null ? codigoTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContacto)) {
            return false;
        }
        TipoContacto other = (TipoContacto) object;
        if ((this.codigoTc == null && other.codigoTc != null) || (this.codigoTc != null && !this.codigoTc.equals(other.codigoTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TipoContacto[ codigoTc=" + codigoTc + " ]";
    }
    
}
