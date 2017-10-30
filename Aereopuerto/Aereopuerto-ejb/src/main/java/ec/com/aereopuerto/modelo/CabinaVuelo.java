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
 * @author sebastian
 */
@Entity
@Table(name = "cabina_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabinaVuelo.findAll", query = "SELECT c FROM CabinaVuelo c")
    , @NamedQuery(name = "CabinaVuelo.findByCodigoCv", query = "SELECT c FROM CabinaVuelo c WHERE c.codigoCv = :codigoCv")
    , @NamedQuery(name = "CabinaVuelo.findByNumeroAsientosCv", query = "SELECT c FROM CabinaVuelo c WHERE c.numeroAsientosCv = :numeroAsientosCv")
    , @NamedQuery(name = "CabinaVuelo.findByNumeroAsientosDisponiblesCv", query = "SELECT c FROM CabinaVuelo c WHERE c.numeroAsientosDisponiblesCv = :numeroAsientosDisponiblesCv")
    , @NamedQuery(name = "CabinaVuelo.findByEstadoCv", query = "SELECT c FROM CabinaVuelo c WHERE c.estadoCv = :estadoCv")
    , @NamedQuery(name = "CabinaVuelo.findByUsuarioActCv", query = "SELECT c FROM CabinaVuelo c WHERE c.usuarioActCv = :usuarioActCv")
    , @NamedQuery(name = "CabinaVuelo.findByFechaActCv", query = "SELECT c FROM CabinaVuelo c WHERE c.fechaActCv = :fechaActCv")})
public class CabinaVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_cv")
    private Integer codigoCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_asientos_cv")
    private int numeroAsientosCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_asientos_disponibles_cv")
    private int numeroAsientosDisponiblesCv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_cv")
    private String estadoCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_cv")
    private int usuarioActCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_cv")
    @Temporal(TemporalType.DATE)
    private Date fechaActCv;
    @JoinColumn(name = "tipo_asiento", referencedColumnName = "codigo_tc")
    @ManyToOne(optional = false)
    private TipoCabina tipoAsiento;
    @JoinColumn(name = "vuelo", referencedColumnName = "codigo_vu")
    @ManyToOne(optional = false)
    private Vuelo vuelo;

    public CabinaVuelo() {
    }

    public CabinaVuelo(Integer codigoCv) {
        this.codigoCv = codigoCv;
    }

    public CabinaVuelo(Integer codigoCv, int numeroAsientosCv, int numeroAsientosDisponiblesCv, String estadoCv, int usuarioActCv, Date fechaActCv) {
        this.codigoCv = codigoCv;
        this.numeroAsientosCv = numeroAsientosCv;
        this.numeroAsientosDisponiblesCv = numeroAsientosDisponiblesCv;
        this.estadoCv = estadoCv;
        this.usuarioActCv = usuarioActCv;
        this.fechaActCv = fechaActCv;
    }

    public Integer getCodigoCv() {
        return codigoCv;
    }

    public void setCodigoCv(Integer codigoCv) {
        this.codigoCv = codigoCv;
    }

    public int getNumeroAsientosCv() {
        return numeroAsientosCv;
    }

    public void setNumeroAsientosCv(int numeroAsientosCv) {
        this.numeroAsientosCv = numeroAsientosCv;
    }

    public int getNumeroAsientosDisponiblesCv() {
        return numeroAsientosDisponiblesCv;
    }

    public void setNumeroAsientosDisponiblesCv(int numeroAsientosDisponiblesCv) {
        this.numeroAsientosDisponiblesCv = numeroAsientosDisponiblesCv;
    }

    public String getEstadoCv() {
        return estadoCv;
    }

    public void setEstadoCv(String estadoCv) {
        this.estadoCv = estadoCv;
    }

    public int getUsuarioActCv() {
        return usuarioActCv;
    }

    public void setUsuarioActCv(int usuarioActCv) {
        this.usuarioActCv = usuarioActCv;
    }

    public Date getFechaActCv() {
        return fechaActCv;
    }

    public void setFechaActCv(Date fechaActCv) {
        this.fechaActCv = fechaActCv;
    }

    public TipoCabina getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoCabina tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCv != null ? codigoCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabinaVuelo)) {
            return false;
        }
        CabinaVuelo other = (CabinaVuelo) object;
        if ((this.codigoCv == null && other.codigoCv != null) || (this.codigoCv != null && !this.codigoCv.equals(other.codigoCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CabinaVuelo[ codigoCv=" + codigoCv + " ]";
    }
    
}
