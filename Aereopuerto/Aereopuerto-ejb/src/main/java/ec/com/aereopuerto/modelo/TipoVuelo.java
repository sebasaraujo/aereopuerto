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
@Table(name = "tipo_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVuelo.findAll", query = "SELECT t FROM TipoVuelo t")
    , @NamedQuery(name = "TipoVuelo.findByCodigoTv", query = "SELECT t FROM TipoVuelo t WHERE t.codigoTv = :codigoTv")
    , @NamedQuery(name = "TipoVuelo.findByNombreTv", query = "SELECT t FROM TipoVuelo t WHERE t.nombreTv = :nombreTv")
    , @NamedQuery(name = "TipoVuelo.findByEstadoTv", query = "SELECT t FROM TipoVuelo t WHERE t.estadoTv = :estadoTv")
    , @NamedQuery(name = "TipoVuelo.findByUsuarioActTv", query = "SELECT t FROM TipoVuelo t WHERE t.usuarioActTv = :usuarioActTv")
    , @NamedQuery(name = "TipoVuelo.findByFechaActTv", query = "SELECT t FROM TipoVuelo t WHERE t.fechaActTv = :fechaActTv")})
public class TipoVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tv")
    private Integer codigoTv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tv")
    private String nombreTv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_tv")
    private String estadoTv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_tv")
    private int usuarioActTv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_tv")
    @Temporal(TemporalType.DATE)
    private Date fechaActTv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVuelo")
    private List<Vuelo> vueloList;

    public TipoVuelo() {
    }

    public TipoVuelo(Integer codigoTv) {
        this.codigoTv = codigoTv;
    }

    public TipoVuelo(Integer codigoTv, String nombreTv, String estadoTv, int usuarioActTv, Date fechaActTv) {
        this.codigoTv = codigoTv;
        this.nombreTv = nombreTv;
        this.estadoTv = estadoTv;
        this.usuarioActTv = usuarioActTv;
        this.fechaActTv = fechaActTv;
    }

    public Integer getCodigoTv() {
        return codigoTv;
    }

    public void setCodigoTv(Integer codigoTv) {
        this.codigoTv = codigoTv;
    }

    public String getNombreTv() {
        return nombreTv;
    }

    public void setNombreTv(String nombreTv) {
        this.nombreTv = nombreTv;
    }

    public String getEstadoTv() {
        return estadoTv;
    }

    public void setEstadoTv(String estadoTv) {
        this.estadoTv = estadoTv;
    }

    public int getUsuarioActTv() {
        return usuarioActTv;
    }

    public void setUsuarioActTv(int usuarioActTv) {
        this.usuarioActTv = usuarioActTv;
    }

    public Date getFechaActTv() {
        return fechaActTv;
    }

    public void setFechaActTv(Date fechaActTv) {
        this.fechaActTv = fechaActTv;
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
        hash += (codigoTv != null ? codigoTv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVuelo)) {
            return false;
        }
        TipoVuelo other = (TipoVuelo) object;
        if ((this.codigoTv == null && other.codigoTv != null) || (this.codigoTv != null && !this.codigoTv.equals(other.codigoTv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TipoVuelo[ codigoTv=" + codigoTv + " ]";
    }
    
}
