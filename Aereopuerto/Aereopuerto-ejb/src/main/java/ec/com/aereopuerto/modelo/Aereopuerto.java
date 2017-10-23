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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aereopuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aereopuerto.findAll", query = "SELECT a FROM Aereopuerto a")
    , @NamedQuery(name = "Aereopuerto.findByCodigoAe", query = "SELECT a FROM Aereopuerto a WHERE a.codigoAe = :codigoAe")
    , @NamedQuery(name = "Aereopuerto.findByNombreAe", query = "SELECT a FROM Aereopuerto a WHERE a.nombreAe = :nombreAe")
    , @NamedQuery(name = "Aereopuerto.findByEstadoAe", query = "SELECT a FROM Aereopuerto a WHERE a.estadoAe = :estadoAe")
    , @NamedQuery(name = "Aereopuerto.findByUsuarioActAe", query = "SELECT a FROM Aereopuerto a WHERE a.usuarioActAe = :usuarioActAe")
    , @NamedQuery(name = "Aereopuerto.findByFechaActAe", query = "SELECT a FROM Aereopuerto a WHERE a.fechaActAe = :fechaActAe")})
public class Aereopuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ae")
    private Integer codigoAe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_ae")
    private String nombreAe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_ae")
    private String estadoAe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_ae")
    private int usuarioActAe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_ae")
    @Temporal(TemporalType.DATE)
    private Date fechaActAe;
    @JoinColumn(name = "ciudad", referencedColumnName = "codigo_ci")
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desdeRs")
    private List<Reserva> reservaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "haciaRs")
    private List<Reserva> reservaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aereopuerto")
    private List<Vuelo> vueloList;

    public Aereopuerto() {
    }

    public Aereopuerto(Integer codigoAe) {
        this.codigoAe = codigoAe;
    }

    public Aereopuerto(Integer codigoAe, String nombreAe, String estadoAe, int usuarioActAe, Date fechaActAe) {
        this.codigoAe = codigoAe;
        this.nombreAe = nombreAe;
        this.estadoAe = estadoAe;
        this.usuarioActAe = usuarioActAe;
        this.fechaActAe = fechaActAe;
    }

    public Integer getCodigoAe() {
        return codigoAe;
    }

    public void setCodigoAe(Integer codigoAe) {
        this.codigoAe = codigoAe;
    }

    public String getNombreAe() {
        return nombreAe;
    }

    public void setNombreAe(String nombreAe) {
        this.nombreAe = nombreAe;
    }

    public String getEstadoAe() {
        return estadoAe;
    }

    public void setEstadoAe(String estadoAe) {
        this.estadoAe = estadoAe;
    }

    public int getUsuarioActAe() {
        return usuarioActAe;
    }

    public void setUsuarioActAe(int usuarioActAe) {
        this.usuarioActAe = usuarioActAe;
    }

    public Date getFechaActAe() {
        return fechaActAe;
    }

    public void setFechaActAe(Date fechaActAe) {
        this.fechaActAe = fechaActAe;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @XmlTransient
    public List<Reserva> getReservaList1() {
        return reservaList1;
    }

    public void setReservaList1(List<Reserva> reservaList1) {
        this.reservaList1 = reservaList1;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAe != null ? codigoAe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aereopuerto)) {
            return false;
        }
        Aereopuerto other = (Aereopuerto) object;
        if ((this.codigoAe == null && other.codigoAe != null) || (this.codigoAe != null && !this.codigoAe.equals(other.codigoAe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Aereopuerto[ codigoAe=" + codigoAe + " ]";
    }
    
}
