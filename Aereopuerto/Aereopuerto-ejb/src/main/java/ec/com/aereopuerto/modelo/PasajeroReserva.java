/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "pasajero_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasajeroReserva.findAll", query = "SELECT p FROM PasajeroReserva p")
    , @NamedQuery(name = "PasajeroReserva.findByCodigoPr", query = "SELECT p FROM PasajeroReserva p WHERE p.codigoPr = :codigoPr")})
public class PasajeroReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pr")
    private Integer codigoPr;
    @JoinColumn(name = "pasajero", referencedColumnName = "codigo_ps")
    @ManyToOne(optional = false)
    private Pasajero pasajero;
    @JoinColumn(name = "reserva", referencedColumnName = "codigo_rs")
    @ManyToOne(optional = false)
    private Reserva reserva;

    public PasajeroReserva() {
    }

    public PasajeroReserva(Integer codigoPr) {
        this.codigoPr = codigoPr;
    }

    public Integer getCodigoPr() {
        return codigoPr;
    }

    public void setCodigoPr(Integer codigoPr) {
        this.codigoPr = codigoPr;
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
        hash += (codigoPr != null ? codigoPr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasajeroReserva)) {
            return false;
        }
        PasajeroReserva other = (PasajeroReserva) object;
        if ((this.codigoPr == null && other.codigoPr != null) || (this.codigoPr != null && !this.codigoPr.equals(other.codigoPr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.PasajeroReserva[ codigoPr=" + codigoPr + " ]";
    }
    
}
