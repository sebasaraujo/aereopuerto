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
 * @author sebastian
 */
@Entity
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findByCodigoVu", query = "SELECT v FROM Vuelo v WHERE v.codigoVu = :codigoVu")
    , @NamedQuery(name = "Vuelo.findByNumeroVu", query = "SELECT v FROM Vuelo v WHERE v.numeroVu = :numeroVu")
    , @NamedQuery(name = "Vuelo.findByFechaVu", query = "SELECT v FROM Vuelo v WHERE v.fechaVu = :fechaVu")
    , @NamedQuery(name = "Vuelo.findByHoraVu", query = "SELECT v FROM Vuelo v WHERE v.horaVu = :horaVu")
    , @NamedQuery(name = "Vuelo.findByDuracionVu", query = "SELECT v FROM Vuelo v WHERE v.duracionVu = :duracionVu")
    , @NamedQuery(name = "Vuelo.findByEstadoVu", query = "SELECT v FROM Vuelo v WHERE v.estadoVu = :estadoVu")
    , @NamedQuery(name = "Vuelo.findByUsuarioActVu", query = "SELECT v FROM Vuelo v WHERE v.usuarioActVu = :usuarioActVu")
    , @NamedQuery(name = "Vuelo.findByFechaActVu", query = "SELECT v FROM Vuelo v WHERE v.fechaActVu = :fechaActVu")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_vu")
    private Integer codigoVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_vu")
    private String numeroVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vu")
    @Temporal(TemporalType.DATE)
    private Date fechaVu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hora_vu")
    private Double horaVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_vu")
    private double duracionVu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_vu")
    private String estadoVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_vu")
    private int usuarioActVu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_vu")
    @Temporal(TemporalType.DATE)
    private Date fechaActVu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<ProductoVuelo> productoVueloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<CabinaVuelo> cabinaVueloList;
    @JoinColumn(name = "aereolinea", referencedColumnName = "codigo_ar")
    @ManyToOne(optional = false)
    private Aereolinea aereolinea;
    @JoinColumn(name = "aereopuerto", referencedColumnName = "codigo_ae")
    @ManyToOne(optional = false)
    private Aereopuerto aereopuerto;
    @JoinColumn(name = "aereopuerto_llegada", referencedColumnName = "codigo_ae")
    @ManyToOne
    private Aereopuerto aereopuertoLlegada;
    @JoinColumn(name = "tipo_estado", referencedColumnName = "codigo_te")
    @ManyToOne(optional = false)
    private TipoEstado tipoEstado;
    @JoinColumn(name = "tipo_vuelo", referencedColumnName = "codigo_tv")
    @ManyToOne(optional = false)
    private TipoVuelo tipoVuelo;

    public Vuelo() {
    }

    public Vuelo(Integer codigoVu) {
        this.codigoVu = codigoVu;
    }

    public Vuelo(Integer codigoVu, String numeroVu, Date fechaVu, double duracionVu, String estadoVu, int usuarioActVu, Date fechaActVu) {
        this.codigoVu = codigoVu;
        this.numeroVu = numeroVu;
        this.fechaVu = fechaVu;
        this.duracionVu = duracionVu;
        this.estadoVu = estadoVu;
        this.usuarioActVu = usuarioActVu;
        this.fechaActVu = fechaActVu;
    }

    public Integer getCodigoVu() {
        return codigoVu;
    }

    public void setCodigoVu(Integer codigoVu) {
        this.codigoVu = codigoVu;
    }

    public String getNumeroVu() {
        return numeroVu;
    }

    public void setNumeroVu(String numeroVu) {
        this.numeroVu = numeroVu;
    }

    public Date getFechaVu() {
        return fechaVu;
    }

    public void setFechaVu(Date fechaVu) {
        this.fechaVu = fechaVu;
    }

    public Double getHoraVu() {
        return horaVu;
    }

    public void setHoraVu(Double horaVu) {
        this.horaVu = horaVu;
    }

    public double getDuracionVu() {
        return duracionVu;
    }

    public void setDuracionVu(double duracionVu) {
        this.duracionVu = duracionVu;
    }

    public String getEstadoVu() {
        return estadoVu;
    }

    public void setEstadoVu(String estadoVu) {
        this.estadoVu = estadoVu;
    }

    public int getUsuarioActVu() {
        return usuarioActVu;
    }

    public void setUsuarioActVu(int usuarioActVu) {
        this.usuarioActVu = usuarioActVu;
    }

    public Date getFechaActVu() {
        return fechaActVu;
    }

    public void setFechaActVu(Date fechaActVu) {
        this.fechaActVu = fechaActVu;
    }

    @XmlTransient
    public List<ProductoVuelo> getProductoVueloList() {
        return productoVueloList;
    }

    public void setProductoVueloList(List<ProductoVuelo> productoVueloList) {
        this.productoVueloList = productoVueloList;
    }

    @XmlTransient
    public List<CabinaVuelo> getCabinaVueloList() {
        return cabinaVueloList;
    }

    public void setCabinaVueloList(List<CabinaVuelo> cabinaVueloList) {
        this.cabinaVueloList = cabinaVueloList;
    }

    public Aereolinea getAereolinea() {
        return aereolinea;
    }

    public void setAereolinea(Aereolinea aereolinea) {
        this.aereolinea = aereolinea;
    }

    public Aereopuerto getAereopuerto() {
        return aereopuerto;
    }

    public void setAereopuerto(Aereopuerto aereopuerto) {
        this.aereopuerto = aereopuerto;
    }

    public Aereopuerto getAereopuertoLlegada() {
        return aereopuertoLlegada;
    }

    public void setAereopuertoLlegada(Aereopuerto aereopuertoLlegada) {
        this.aereopuertoLlegada = aereopuertoLlegada;
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVu != null ? codigoVu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.codigoVu == null && other.codigoVu != null) || (this.codigoVu != null && !this.codigoVu.equals(other.codigoVu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vuelo[ codigoVu=" + codigoVu + " ]";
    }
    
}
