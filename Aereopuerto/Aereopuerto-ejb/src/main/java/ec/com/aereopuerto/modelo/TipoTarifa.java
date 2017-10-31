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
@Table(name = "tipo_tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTarifa.findAll", query = "SELECT t FROM TipoTarifa t")
    , @NamedQuery(name = "TipoTarifa.findByCodigoTt", query = "SELECT t FROM TipoTarifa t WHERE t.codigoTt = :codigoTt")
    , @NamedQuery(name = "TipoTarifa.findByNombreTt", query = "SELECT t FROM TipoTarifa t WHERE t.nombreTt = :nombreTt")
    , @NamedQuery(name = "TipoTarifa.findByEstadoTt", query = "SELECT t FROM TipoTarifa t WHERE t.estadoTt = :estadoTt")
    , @NamedQuery(name = "TipoTarifa.findByUsuarioActTt", query = "SELECT t FROM TipoTarifa t WHERE t.usuarioActTt = :usuarioActTt")
    , @NamedQuery(name = "TipoTarifa.findByFechaActTt", query = "SELECT t FROM TipoTarifa t WHERE t.fechaActTt = :fechaActTt")})
public class TipoTarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tt")
    private Integer codigoTt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_tt")
    private String nombreTt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tt")
    private String estadoTt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tt")
    private int usuarioActTt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tt")
    @Temporal(TemporalType.DATE)
    private Date fechaActTt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTarifa")
    private List<TarifaProducto> tarifaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTarifa")
    private List<TarifaCondiciones> tarifaCondicionesList;

    public TipoTarifa() {
    }

    public TipoTarifa(Integer codigoTt) {
        this.codigoTt = codigoTt;
    }

    public TipoTarifa(Integer codigoTt, String nombreTt, String estadoTt, int usuarioActTt, Date fechaActTt) {
        this.codigoTt = codigoTt;
        this.nombreTt = nombreTt;
        this.estadoTt = estadoTt;
        this.usuarioActTt = usuarioActTt;
        this.fechaActTt = fechaActTt;
    }

    public Integer getCodigoTt() {
        return codigoTt;
    }

    public void setCodigoTt(Integer codigoTt) {
        this.codigoTt = codigoTt;
    }

    public String getNombreTt() {
        return nombreTt;
    }

    public void setNombreTt(String nombreTt) {
        this.nombreTt = nombreTt;
    }

    public String getEstadoTt() {
        return estadoTt;
    }

    public void setEstadoTt(String estadoTt) {
        this.estadoTt = estadoTt;
    }

    public int getUsuarioActTt() {
        return usuarioActTt;
    }

    public void setUsuarioActTt(int usuarioActTt) {
        this.usuarioActTt = usuarioActTt;
    }

    public Date getFechaActTt() {
        return fechaActTt;
    }

    public void setFechaActTt(Date fechaActTt) {
        this.fechaActTt = fechaActTt;
    }

    @XmlTransient
    public List<TarifaProducto> getTarifaProductoList() {
        return tarifaProductoList;
    }

    public void setTarifaProductoList(List<TarifaProducto> tarifaProductoList) {
        this.tarifaProductoList = tarifaProductoList;
    }

    public List<TarifaCondiciones> getTarifaCondicionesList() {
		return tarifaCondicionesList;
	}

	public void setTarifaCondicionesList(List<TarifaCondiciones> tarifaCondicionesList) {
		this.tarifaCondicionesList = tarifaCondicionesList;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTt != null ? codigoTt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTarifa)) {
            return false;
        }
        TipoTarifa other = (TipoTarifa) object;
        if ((this.codigoTt == null && other.codigoTt != null) || (this.codigoTt != null && !this.codigoTt.equals(other.codigoTt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoTarifa[ codigoTt=" + codigoTt + " ]";
    }
    
}
