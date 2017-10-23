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
@Table(name = "tipo_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReserva.findAll", query = "SELECT t FROM TipoReserva t")
    , @NamedQuery(name = "TipoReserva.findByCodigoTr", query = "SELECT t FROM TipoReserva t WHERE t.codigoTr = :codigoTr")
    , @NamedQuery(name = "TipoReserva.findByNombreTr", query = "SELECT t FROM TipoReserva t WHERE t.nombreTr = :nombreTr")
    , @NamedQuery(name = "TipoReserva.findByEstadoTr", query = "SELECT t FROM TipoReserva t WHERE t.estadoTr = :estadoTr")
    , @NamedQuery(name = "TipoReserva.findByUsuarioActTr", query = "SELECT t FROM TipoReserva t WHERE t.usuarioActTr = :usuarioActTr")
    , @NamedQuery(name = "TipoReserva.findByFechaActTr", query = "SELECT t FROM TipoReserva t WHERE t.fechaActTr = :fechaActTr")})
public class TipoReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tr")
    private Integer codigoTr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tr")
    private String nombreTr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tr")
    private String estadoTr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tr")
    private int usuarioActTr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tr")
    @Temporal(TemporalType.DATE)
    private Date fechaActTr;

    public TipoReserva() {
    }

    public TipoReserva(Integer codigoTr) {
        this.codigoTr = codigoTr;
    }

    public TipoReserva(Integer codigoTr, String nombreTr, String estadoTr, int usuarioActTr, Date fechaActTr) {
        this.codigoTr = codigoTr;
        this.nombreTr = nombreTr;
        this.estadoTr = estadoTr;
        this.usuarioActTr = usuarioActTr;
        this.fechaActTr = fechaActTr;
    }

    public Integer getCodigoTr() {
        return codigoTr;
    }

    public void setCodigoTr(Integer codigoTr) {
        this.codigoTr = codigoTr;
    }

    public String getNombreTr() {
        return nombreTr;
    }

    public void setNombreTr(String nombreTr) {
        this.nombreTr = nombreTr;
    }

    public String getEstadoTr() {
        return estadoTr;
    }

    public void setEstadoTr(String estadoTr) {
        this.estadoTr = estadoTr;
    }

    public int getUsuarioActTr() {
        return usuarioActTr;
    }

    public void setUsuarioActTr(int usuarioActTr) {
        this.usuarioActTr = usuarioActTr;
    }

    public Date getFechaActTr() {
        return fechaActTr;
    }

    public void setFechaActTr(Date fechaActTr) {
        this.fechaActTr = fechaActTr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTr != null ? codigoTr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReserva)) {
            return false;
        }
        TipoReserva other = (TipoReserva) object;
        if ((this.codigoTr == null && other.codigoTr != null) || (this.codigoTr != null && !this.codigoTr.equals(other.codigoTr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TipoReserva[ codigoTr=" + codigoTr + " ]";
    }
    
}
