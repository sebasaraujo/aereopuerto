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
@Table(name = "pasajero_costo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasajeroCosto.findAll", query = "SELECT p FROM PasajeroCosto p")
    , @NamedQuery(name = "PasajeroCosto.findByCodigoPc", query = "SELECT p FROM PasajeroCosto p WHERE p.codigoPc = :codigoPc")
    , @NamedQuery(name = "PasajeroCosto.findByTarifaPc", query = "SELECT p FROM PasajeroCosto p WHERE p.tarifaPc = :tarifaPc")
    , @NamedQuery(name = "PasajeroCosto.findByImpuestoPc", query = "SELECT p FROM PasajeroCosto p WHERE p.impuestoPc = :impuestoPc")
    , @NamedQuery(name = "PasajeroCosto.findByEstadoPc", query = "SELECT p FROM PasajeroCosto p WHERE p.estadoPc = :estadoPc")
    , @NamedQuery(name = "PasajeroCosto.findByUsuarioActPc", query = "SELECT p FROM PasajeroCosto p WHERE p.usuarioActPc = :usuarioActPc")
    , @NamedQuery(name = "PasajeroCosto.findByFechaActPc", query = "SELECT p FROM PasajeroCosto p WHERE p.fechaActPc = :fechaActPc")})
public class PasajeroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pc")
    private Integer codigoPc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tarifa_pc")
    private Double tarifaPc;
    @Column(name = "impuesto_pc")
    private Double impuestoPc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_pc")
    private String estadoPc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_pc")
    private int usuarioActPc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_pc")
    @Temporal(TemporalType.DATE)
    private Date fechaActPc;
    @JoinColumn(name = "pasajero", referencedColumnName = "codigo_ps")
    @ManyToOne
    private Pasajero pasajero;
    @JoinColumn(name = "reserva", referencedColumnName = "codigo_rs")
    @ManyToOne
    private Reserva reserva;

    public PasajeroCosto() {
    }

    public PasajeroCosto(Integer codigoPc) {
        this.codigoPc = codigoPc;
    }

    public PasajeroCosto(Integer codigoPc, String estadoPc, int usuarioActPc, Date fechaActPc) {
        this.codigoPc = codigoPc;
        this.estadoPc = estadoPc;
        this.usuarioActPc = usuarioActPc;
        this.fechaActPc = fechaActPc;
    }

    public Integer getCodigoPc() {
        return codigoPc;
    }

    public void setCodigoPc(Integer codigoPc) {
        this.codigoPc = codigoPc;
    }

    public Double getTarifaPc() {
        return tarifaPc;
    }

    public void setTarifaPc(Double tarifaPc) {
        this.tarifaPc = tarifaPc;
    }

    public Double getImpuestoPc() {
        return impuestoPc;
    }

    public void setImpuestoPc(Double impuestoPc) {
        this.impuestoPc = impuestoPc;
    }

    public String getEstadoPc() {
        return estadoPc;
    }

    public void setEstadoPc(String estadoPc) {
        this.estadoPc = estadoPc;
    }

    public int getUsuarioActPc() {
        return usuarioActPc;
    }

    public void setUsuarioActPc(int usuarioActPc) {
        this.usuarioActPc = usuarioActPc;
    }

    public Date getFechaActPc() {
        return fechaActPc;
    }

    public void setFechaActPc(Date fechaActPc) {
        this.fechaActPc = fechaActPc;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPc != null ? codigoPc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasajeroCosto)) {
            return false;
        }
        PasajeroCosto other = (PasajeroCosto) object;
        if ((this.codigoPc == null && other.codigoPc != null) || (this.codigoPc != null && !this.codigoPc.equals(other.codigoPc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.PasajeroCosto[ codigoPc=" + codigoPc + " ]";
    }
    
}
