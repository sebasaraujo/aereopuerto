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
@Table(name = "aereolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aereolinea.findAll", query = "SELECT a FROM Aereolinea a")
    , @NamedQuery(name = "Aereolinea.findByCodigoAr", query = "SELECT a FROM Aereolinea a WHERE a.codigoAr = :codigoAr")
    , @NamedQuery(name = "Aereolinea.findByNombreAr", query = "SELECT a FROM Aereolinea a WHERE a.nombreAr = :nombreAr")
    , @NamedQuery(name = "Aereolinea.findByEstadoAr", query = "SELECT a FROM Aereolinea a WHERE a.estadoAr = :estadoAr")
    , @NamedQuery(name = "Aereolinea.findByUsuarioActAr", query = "SELECT a FROM Aereolinea a WHERE a.usuarioActAr = :usuarioActAr")
    , @NamedQuery(name = "Aereolinea.findByFechaActAr", query = "SELECT a FROM Aereolinea a WHERE a.fechaActAr = :fechaActAr")})
public class Aereolinea implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aereolinea")
    private List<Producto> productoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ar")
    private Integer codigoAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_ar")
    private String nombreAr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_ar")
    private String estadoAr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_ar")
    private int usuarioActAr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_ar")
    @Temporal(TemporalType.DATE)
    private Date fechaActAr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aereolinea")
    private List<Vuelo> vueloList;

    public Aereolinea() {
    }

    public Aereolinea(Integer codigoAr) {
        this.codigoAr = codigoAr;
    }

    public Aereolinea(Integer codigoAr, String nombreAr, String estadoAr, int usuarioActAr, Date fechaActAr) {
        this.codigoAr = codigoAr;
        this.nombreAr = nombreAr;
        this.estadoAr = estadoAr;
        this.usuarioActAr = usuarioActAr;
        this.fechaActAr = fechaActAr;
    }

    public Integer getCodigoAr() {
        return codigoAr;
    }

    public void setCodigoAr(Integer codigoAr) {
        this.codigoAr = codigoAr;
    }

    public String getNombreAr() {
        return nombreAr;
    }

    public void setNombreAr(String nombreAr) {
        this.nombreAr = nombreAr;
    }

    public String getEstadoAr() {
        return estadoAr;
    }

    public void setEstadoAr(String estadoAr) {
        this.estadoAr = estadoAr;
    }

    public int getUsuarioActAr() {
        return usuarioActAr;
    }

    public void setUsuarioActAr(int usuarioActAr) {
        this.usuarioActAr = usuarioActAr;
    }

    public Date getFechaActAr() {
        return fechaActAr;
    }

    public void setFechaActAr(Date fechaActAr) {
        this.fechaActAr = fechaActAr;
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
        hash += (codigoAr != null ? codigoAr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aereolinea)) {
            return false;
        }
        Aereolinea other = (Aereolinea) object;
        if ((this.codigoAr == null && other.codigoAr != null) || (this.codigoAr != null && !this.codigoAr.equals(other.codigoAr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Aereolinea[ codigoAr=" + codigoAr + " ]";
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }
    
}
