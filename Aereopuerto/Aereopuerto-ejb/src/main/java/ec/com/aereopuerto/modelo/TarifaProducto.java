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
@Table(name = "tarifa_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaProducto.findAll", query = "SELECT t FROM TarifaProducto t")
    , @NamedQuery(name = "TarifaProducto.findByCodigoTp", query = "SELECT t FROM TarifaProducto t WHERE t.codigoTp = :codigoTp")
    , @NamedQuery(name = "TarifaProducto.findByCostoTp", query = "SELECT t FROM TarifaProducto t WHERE t.costoTp = :costoTp")
    , @NamedQuery(name = "TarifaProducto.findByEstadoTp", query = "SELECT t FROM TarifaProducto t WHERE t.estadoTp = :estadoTp")
    , @NamedQuery(name = "TarifaProducto.findByUsuarioActTp", query = "SELECT t FROM TarifaProducto t WHERE t.usuarioActTp = :usuarioActTp")
    , @NamedQuery(name = "TarifaProducto.findByFechaActTp", query = "SELECT t FROM TarifaProducto t WHERE t.fechaActTp = :fechaActTp")})
public class TarifaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tp")
    private Integer codigoTp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_tp")
    private double costoTp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tp")
    private String estadoTp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tp")
    private int usuarioActTp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tp")
    @Temporal(TemporalType.DATE)
    private Date fechaActTp;
    @JoinColumn(name = "producto", referencedColumnName = "codigo_po")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "tipo_cabina", referencedColumnName = "codigo_tc")
    @ManyToOne(optional = false)
    private TipoCabina tipoCabina;
    @JoinColumn(name = "tipo_tarifa", referencedColumnName = "codigo_tt")
    @ManyToOne(optional = false)
    private TipoTarifa tipoTarifa;

    public TarifaProducto() {
    }

    public TarifaProducto(Integer codigoTp) {
        this.codigoTp = codigoTp;
    }

    public TarifaProducto(Integer codigoTp, double costoTp, String estadoTp, int usuarioActTp, Date fechaActTp) {
        this.codigoTp = codigoTp;
        this.costoTp = costoTp;
        this.estadoTp = estadoTp;
        this.usuarioActTp = usuarioActTp;
        this.fechaActTp = fechaActTp;
    }

    public Integer getCodigoTp() {
        return codigoTp;
    }

    public void setCodigoTp(Integer codigoTp) {
        this.codigoTp = codigoTp;
    }

    public double getCostoTp() {
        return costoTp;
    }

    public void setCostoTp(double costoTp) {
        this.costoTp = costoTp;
    }

    public String getEstadoTp() {
        return estadoTp;
    }

    public void setEstadoTp(String estadoTp) {
        this.estadoTp = estadoTp;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoCabina getTipoCabina() {
        return tipoCabina;
    }

    public void setTipoCabina(TipoCabina tipoCabina) {
        this.tipoCabina = tipoCabina;
    }

    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(TipoTarifa tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTp != null ? codigoTp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaProducto)) {
            return false;
        }
        TarifaProducto other = (TarifaProducto) object;
        if ((this.codigoTp == null && other.codigoTp != null) || (this.codigoTp != null && !this.codigoTp.equals(other.codigoTp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TarifaProducto[ codigoTp=" + codigoTp + " ]";
    }
    
}
