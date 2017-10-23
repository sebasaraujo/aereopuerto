/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "contacto_pasajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoPasajero.findAll", query = "SELECT c FROM ContactoPasajero c")
    , @NamedQuery(name = "ContactoPasajero.findByCodigoCp", query = "SELECT c FROM ContactoPasajero c WHERE c.codigoCp = :codigoCp")
    , @NamedQuery(name = "ContactoPasajero.findByNumeroCp", query = "SELECT c FROM ContactoPasajero c WHERE c.numeroCp = :numeroCp")
    , @NamedQuery(name = "ContactoPasajero.findByEstadoCp", query = "SELECT c FROM ContactoPasajero c WHERE c.estadoCp = :estadoCp")
    , @NamedQuery(name = "ContactoPasajero.findByUsuarioActCp", query = "SELECT c FROM ContactoPasajero c WHERE c.usuarioActCp = :usuarioActCp")
    , @NamedQuery(name = "ContactoPasajero.findByFechaActCp", query = "SELECT c FROM ContactoPasajero c WHERE c.fechaActCp = :fechaActCp")})
public class ContactoPasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_cp")
    private Integer codigoCp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_cp")
    private String numeroCp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_cp")
    private String estadoCp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_cp")
    private int usuarioActCp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_cp")
    @Temporal(TemporalType.DATE)
    private Date fechaActCp;
    @JoinColumn(name = "pasajero", referencedColumnName = "codigo_ps")
    @ManyToOne(optional = false)
    private Pasajero pasajero;
    @JoinColumn(name = "tipo_contacto", referencedColumnName = "codigo_tc")
    @ManyToOne(optional = false)
    private TipoContacto tipoContacto;

    public ContactoPasajero() {
    }

    public ContactoPasajero(Integer codigoCp) {
        this.codigoCp = codigoCp;
    }

    public ContactoPasajero(Integer codigoCp, String numeroCp, String estadoCp, int usuarioActCp, Date fechaActCp) {
        this.codigoCp = codigoCp;
        this.numeroCp = numeroCp;
        this.estadoCp = estadoCp;
        this.usuarioActCp = usuarioActCp;
        this.fechaActCp = fechaActCp;
    }

    public Integer getCodigoCp() {
        return codigoCp;
    }

    public void setCodigoCp(Integer codigoCp) {
        this.codigoCp = codigoCp;
    }

    public String getNumeroCp() {
        return numeroCp;
    }

    public void setNumeroCp(String numeroCp) {
        this.numeroCp = numeroCp;
    }

    public String getEstadoCp() {
        return estadoCp;
    }

    public void setEstadoCp(String estadoCp) {
        this.estadoCp = estadoCp;
    }

    public int getUsuarioActCp() {
        return usuarioActCp;
    }

    public void setUsuarioActCp(int usuarioActCp) {
        this.usuarioActCp = usuarioActCp;
    }

    public Date getFechaActCp() {
        return fechaActCp;
    }

    public void setFechaActCp(Date fechaActCp) {
        this.fechaActCp = fechaActCp;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public TipoContacto getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(TipoContacto tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCp != null ? codigoCp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoPasajero)) {
            return false;
        }
        ContactoPasajero other = (ContactoPasajero) object;
        if ((this.codigoCp == null && other.codigoCp != null) || (this.codigoCp != null && !this.codigoCp.equals(other.codigoCp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.ContactoPasajero[ codigoCp=" + codigoCp + " ]";
    }
    
}
