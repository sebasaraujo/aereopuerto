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
 * @author luisp.araujo
 */
@Entity
@Table(name = "impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i")
    , @NamedQuery(name = "Impuesto.findByCodigoIm", query = "SELECT i FROM Impuesto i WHERE i.codigoIm = :codigoIm")
    , @NamedQuery(name = "Impuesto.findByValorIm", query = "SELECT i FROM Impuesto i WHERE i.valorIm = :valorIm")
    , @NamedQuery(name = "Impuesto.findByDescripcionIm", query = "SELECT i FROM Impuesto i WHERE i.descripcionIm = :descripcionIm")
    , @NamedQuery(name = "Impuesto.findByNemonicoIm", query = "SELECT i FROM Impuesto i WHERE i.nemonicoIm = :nemonicoIm")
    , @NamedQuery(name = "Impuesto.findByEstadoIm", query = "SELECT i FROM Impuesto i WHERE i.estadoIm = :estadoIm")
    , @NamedQuery(name = "Impuesto.findByUsuarioActIm", query = "SELECT i FROM Impuesto i WHERE i.usuarioActIm = :usuarioActIm")
    , @NamedQuery(name = "Impuesto.findByFechaActIm", query = "SELECT i FROM Impuesto i WHERE i.fechaActIm = :fechaActIm")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_im")
    private Integer codigoIm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_im")
    private int valorIm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion_im")
    private String descripcionIm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nemonico_im")
    private String nemonicoIm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_im")
    private String estadoIm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_im")
    private int usuarioActIm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_im")
    @Temporal(TemporalType.DATE)
    private Date fechaActIm;
    @JoinColumn(name = "tipo_impuesto", referencedColumnName = "codigo_ti")
    @ManyToOne(optional = false)
    private TipoImpuesto tipoImpuesto;

    public Impuesto() {
    }

    public Impuesto(Integer codigoIm) {
        this.codigoIm = codigoIm;
    }

    public Impuesto(Integer codigoIm, int valorIm, String descripcionIm, String nemonicoIm, String estadoIm, int usuarioActIm, Date fechaActIm) {
        this.codigoIm = codigoIm;
        this.valorIm = valorIm;
        this.descripcionIm = descripcionIm;
        this.nemonicoIm = nemonicoIm;
        this.estadoIm = estadoIm;
        this.usuarioActIm = usuarioActIm;
        this.fechaActIm = fechaActIm;
    }

    public Integer getCodigoIm() {
        return codigoIm;
    }

    public void setCodigoIm(Integer codigoIm) {
        this.codigoIm = codigoIm;
    }

    public int getValorIm() {
        return valorIm;
    }

    public void setValorIm(int valorIm) {
        this.valorIm = valorIm;
    }

    public String getDescripcionIm() {
        return descripcionIm;
    }

    public void setDescripcionIm(String descripcionIm) {
        this.descripcionIm = descripcionIm;
    }

    public String getNemonicoIm() {
        return nemonicoIm;
    }

    public void setNemonicoIm(String nemonicoIm) {
        this.nemonicoIm = nemonicoIm;
    }

    public String getEstadoIm() {
        return estadoIm;
    }

    public void setEstadoIm(String estadoIm) {
        this.estadoIm = estadoIm;
    }

    public int getUsuarioActIm() {
        return usuarioActIm;
    }

    public void setUsuarioActIm(int usuarioActIm) {
        this.usuarioActIm = usuarioActIm;
    }

    public Date getFechaActIm() {
        return fechaActIm;
    }

    public void setFechaActIm(Date fechaActIm) {
        this.fechaActIm = fechaActIm;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoIm != null ? codigoIm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.codigoIm == null && other.codigoIm != null) || (this.codigoIm != null && !this.codigoIm.equals(other.codigoIm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Impuesto[ codigoIm=" + codigoIm + " ]";
    }
    
}
