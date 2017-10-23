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
@Table(name = "tipo_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstado.findAll", query = "SELECT t FROM TipoEstado t")
    , @NamedQuery(name = "TipoEstado.findByCodigoTe", query = "SELECT t FROM TipoEstado t WHERE t.codigoTe = :codigoTe")
    , @NamedQuery(name = "TipoEstado.findByNombreTe", query = "SELECT t FROM TipoEstado t WHERE t.nombreTe = :nombreTe")
    , @NamedQuery(name = "TipoEstado.findByEstadoTe", query = "SELECT t FROM TipoEstado t WHERE t.estadoTe = :estadoTe")
    , @NamedQuery(name = "TipoEstado.findByUsuarioActTe", query = "SELECT t FROM TipoEstado t WHERE t.usuarioActTe = :usuarioActTe")
    , @NamedQuery(name = "TipoEstado.findByFechaActTe", query = "SELECT t FROM TipoEstado t WHERE t.fechaActTe = :fechaActTe")})
public class TipoEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_te")
    private Integer codigoTe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_te")
    private String nombreTe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_te")
    private String estadoTe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_te")
    private int usuarioActTe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_te")
    @Temporal(TemporalType.DATE)
    private Date fechaActTe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEstado")
    private List<Vuelo> vueloList;

    public TipoEstado() {
    }

    public TipoEstado(Integer codigoTe) {
        this.codigoTe = codigoTe;
    }

    public TipoEstado(Integer codigoTe, String nombreTe, String estadoTe, int usuarioActTe, Date fechaActTe) {
        this.codigoTe = codigoTe;
        this.nombreTe = nombreTe;
        this.estadoTe = estadoTe;
        this.usuarioActTe = usuarioActTe;
        this.fechaActTe = fechaActTe;
    }

    public Integer getCodigoTe() {
        return codigoTe;
    }

    public void setCodigoTe(Integer codigoTe) {
        this.codigoTe = codigoTe;
    }

    public String getNombreTe() {
        return nombreTe;
    }

    public void setNombreTe(String nombreTe) {
        this.nombreTe = nombreTe;
    }

    public String getEstadoTe() {
        return estadoTe;
    }

    public void setEstadoTe(String estadoTe) {
        this.estadoTe = estadoTe;
    }

    public int getUsuarioActTe() {
        return usuarioActTe;
    }

    public void setUsuarioActTe(int usuarioActTe) {
        this.usuarioActTe = usuarioActTe;
    }

    public Date getFechaActTe() {
        return fechaActTe;
    }

    public void setFechaActTe(Date fechaActTe) {
        this.fechaActTe = fechaActTe;
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
        hash += (codigoTe != null ? codigoTe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstado)) {
            return false;
        }
        TipoEstado other = (TipoEstado) object;
        if ((this.codigoTe == null && other.codigoTe != null) || (this.codigoTe != null && !this.codigoTe.equals(other.codigoTe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TipoEstado[ codigoTe=" + codigoTe + " ]";
    }
    
}
