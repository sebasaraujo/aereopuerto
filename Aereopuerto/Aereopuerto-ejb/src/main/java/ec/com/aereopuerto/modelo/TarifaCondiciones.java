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
@Table(name = "tarifa_condiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarifaCondiciones.findAll", query = "SELECT t FROM TarifaCondiciones t")
    , @NamedQuery(name = "TarifaCondiciones.findByCodigoTc", query = "SELECT t FROM TarifaCondiciones t WHERE t.codigoTc = :codigoTc")
    , @NamedQuery(name = "TarifaCondiciones.findByDescripcion", query = "SELECT t FROM TarifaCondiciones t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TarifaCondiciones.findByEstadoTc", query = "SELECT t FROM TarifaCondiciones t WHERE t.estadoTc = :estadoTc")
    , @NamedQuery(name = "TarifaCondiciones.findByUsuarioActTc", query = "SELECT t FROM TarifaCondiciones t WHERE t.usuarioActTc = :usuarioActTc")
    , @NamedQuery(name = "TarifaCondiciones.findByFechaActTc", query = "SELECT t FROM TarifaCondiciones t WHERE t.fechaActTc = :fechaActTc")})
public class TarifaCondiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_tc")
    private Integer codigoTc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
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
    @JoinColumn(name = "condicion", referencedColumnName = "codigo_co")
    @ManyToOne(optional = false)
    private Condiciones condicion;
    @JoinColumn(name = "tipo_tarifa", referencedColumnName = "codigo_tt")
    @ManyToOne(optional = false)
    private TipoTarifa tipoTarifa;

    public TarifaCondiciones() {
    }

    public TarifaCondiciones(Integer codigoTc) {
        this.codigoTc = codigoTc;
    }

    public TarifaCondiciones(Integer codigoTc, String descripcion, String estadoTc, int usuarioActTc, Date fechaActTc) {
        this.codigoTc = codigoTc;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Condiciones getCondicion() {
        return condicion;
    }

    public void setCondicion(Condiciones condicion) {
        this.condicion = condicion;
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
        hash += (codigoTc != null ? codigoTc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarifaCondiciones)) {
            return false;
        }
        TarifaCondiciones other = (TarifaCondiciones) object;
        if ((this.codigoTc == null && other.codigoTc != null) || (this.codigoTc != null && !this.codigoTc.equals(other.codigoTc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.TarifaCondiciones[ codigoTc=" + codigoTc + " ]";
    }
    
}
