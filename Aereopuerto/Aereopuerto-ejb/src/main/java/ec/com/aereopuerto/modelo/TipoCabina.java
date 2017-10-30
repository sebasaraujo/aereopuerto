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
 * @author sebastian
 */
@Entity
@Table(name = "tipo_cabina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCabina.findAll", query = "SELECT t FROM TipoCabina t")
    , @NamedQuery(name = "TipoCabina.findByCodigoTc", query = "SELECT t FROM TipoCabina t WHERE t.codigoTc = :codigoTc")
    , @NamedQuery(name = "TipoCabina.findByNombreTc", query = "SELECT t FROM TipoCabina t WHERE t.nombreTc = :nombreTc")
    , @NamedQuery(name = "TipoCabina.findByEstadoTc", query = "SELECT t FROM TipoCabina t WHERE t.estadoTc = :estadoTc")
    , @NamedQuery(name = "TipoCabina.findByUsuarioActTc", query = "SELECT t FROM TipoCabina t WHERE t.usuarioActTc = :usuarioActTc")
    , @NamedQuery(name = "TipoCabina.findByFechaActTc", query = "SELECT t FROM TipoCabina t WHERE t.fechaActTc = :fechaActTc")})
public class TipoCabina implements Serializable {

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
    @Column(name = "usuario_act_tc")
    private int usuarioActTc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tc")
    @Temporal(TemporalType.DATE)
    private Date fechaActTc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCabina")
    private List<TarifaProducto> tarifaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAsiento")
    private List<CabinaVuelo> cabinaVueloList;

    public TipoCabina() {
    }

    public TipoCabina(Integer codigoTc) {
        this.codigoTc = codigoTc;
    }

    public TipoCabina(Integer codigoTc, String nombreTc, String estadoTc, int usuarioActTc, Date fechaActTc) {
        this.codigoTc = codigoTc;
        this.nombreTc = nombreTc;
        this.estadoTc = estadoTc;
        this.usuarioActTc = usuarioActTc;
        this.fechaActTc = fechaActTc;
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

    public int getUsuarioActTc() {
        return usuarioActTc;
    }

    public void setUsuarioActTc(int usuarioActTc) {
        this.usuarioActTc = usuarioActTc;
    }

    public Date getFechaActTc() {
        return fechaActTc;
    }

    public void setFechaActTc(Date fechaActTc) {
        this.fechaActTc = fechaActTc;
    }

    @XmlTransient
    public List<TarifaProducto> getTarifaProductoList() {
        return tarifaProductoList;
    }

    public void setTarifaProductoList(List<TarifaProducto> tarifaProductoList) {
        this.tarifaProductoList = tarifaProductoList;
    }

    @XmlTransient
    public List<CabinaVuelo> getCabinaVueloList() {
        return cabinaVueloList;
    }

    public void setCabinaVueloList(List<CabinaVuelo> cabinaVueloList) {
        this.cabinaVueloList = cabinaVueloList;
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
        if (!(object instanceof TipoCabina)) {
            return false;
        }
        TipoCabina other = (TipoCabina) object;
        if ((this.codigoTc == null && other.codigoTc != null) || (this.codigoTc != null && !this.codigoTc.equals(other.codigoTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoCabina[ codigoTc=" + codigoTc + " ]";
    }
    
}
