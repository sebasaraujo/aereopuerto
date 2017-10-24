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
@Table(name = "tipo_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t")
    , @NamedQuery(name = "TipoProducto.findByCodigoTpr", query = "SELECT t FROM TipoProducto t WHERE t.codigoTpr = :codigoTpr")
    , @NamedQuery(name = "TipoProducto.findByNombreTpr", query = "SELECT t FROM TipoProducto t WHERE t.nombreTpr = :nombreTpr")
    , @NamedQuery(name = "TipoProducto.findByEstadoTpr", query = "SELECT t FROM TipoProducto t WHERE t.estadoTpr = :estadoTpr")
    , @NamedQuery(name = "TipoProducto.findByUsuarioActTpr", query = "SELECT t FROM TipoProducto t WHERE t.usuarioActTpr = :usuarioActTpr")
    , @NamedQuery(name = "TipoProducto.findByFechaActTpr", query = "SELECT t FROM TipoProducto t WHERE t.fechaActTpr = :fechaActTpr")})
public class TipoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tpr")
    private Integer codigoTpr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_tpr")
    private String nombreTpr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tpr")
    private String estadoTpr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tpr")
    private int usuarioActTpr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tpr")
    @Temporal(TemporalType.DATE)
    private Date fechaActTpr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProducto")
    private List<Producto> productoList;

    public TipoProducto() {
    }

    public TipoProducto(Integer codigoTpr) {
        this.codigoTpr = codigoTpr;
    }

    public TipoProducto(Integer codigoTpr, String nombreTpr, String estadoTpr, int usuarioActTpr, Date fechaActTpr) {
        this.codigoTpr = codigoTpr;
        this.nombreTpr = nombreTpr;
        this.estadoTpr = estadoTpr;
        this.usuarioActTpr = usuarioActTpr;
        this.fechaActTpr = fechaActTpr;
    }

    public Integer getCodigoTpr() {
        return codigoTpr;
    }

    public void setCodigoTpr(Integer codigoTpr) {
        this.codigoTpr = codigoTpr;
    }

    public String getNombreTpr() {
        return nombreTpr;
    }

    public void setNombreTpr(String nombreTpr) {
        this.nombreTpr = nombreTpr;
    }

    public String getEstadoTpr() {
        return estadoTpr;
    }

    public void setEstadoTpr(String estadoTpr) {
        this.estadoTpr = estadoTpr;
    }

    public int getUsuarioActTpr() {
        return usuarioActTpr;
    }

    public void setUsuarioActTpr(int usuarioActTpr) {
        this.usuarioActTpr = usuarioActTpr;
    }

    public Date getFechaActTpr() {
        return fechaActTpr;
    }

    public void setFechaActTpr(Date fechaActTpr) {
        this.fechaActTpr = fechaActTpr;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTpr != null ? codigoTpr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.codigoTpr == null && other.codigoTpr != null) || (this.codigoTpr != null && !this.codigoTpr.equals(other.codigoTpr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TipoProducto[ codigoTpr=" + codigoTpr + " ]";
    }
    
}
