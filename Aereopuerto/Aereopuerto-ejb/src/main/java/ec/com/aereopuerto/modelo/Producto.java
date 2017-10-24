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
 * @author luisp.araujo
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigoPo", query = "SELECT p FROM Producto p WHERE p.codigoPo = :codigoPo")
    , @NamedQuery(name = "Producto.findByNombrePo", query = "SELECT p FROM Producto p WHERE p.nombrePo = :nombrePo")
    , @NamedQuery(name = "Producto.findByPrecioPo", query = "SELECT p FROM Producto p WHERE p.precioPo = :precioPo")
    , @NamedQuery(name = "Producto.findByEstadoPo", query = "SELECT p FROM Producto p WHERE p.estadoPo = :estadoPo")
    , @NamedQuery(name = "Producto.findByUsuarioActPo", query = "SELECT p FROM Producto p WHERE p.usuarioActPo = :usuarioActPo")
    , @NamedQuery(name = "Producto.findByFechaActPo", query = "SELECT p FROM Producto p WHERE p.fechaActPo = :fechaActPo")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_po")
    private Integer codigoPo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_po")
    private String nombrePo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_po")
    private double precioPo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_po")
    private String estadoPo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_po")
    private int usuarioActPo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_po")
    @Temporal(TemporalType.DATE)
    private Date fechaActPo;
    @JoinColumn(name = "aereolinea", referencedColumnName = "codigo_ar")
    @ManyToOne(optional = false)
    private Aereolinea aereolinea;
    @JoinColumn(name = "aereopuerto_llegada", referencedColumnName = "codigo_ae")
    @ManyToOne(optional = false)
    private Aereopuerto aereopuertoLlegada;
    @JoinColumn(name = "aereopuerto_salida", referencedColumnName = "codigo_ae")
    @ManyToOne(optional = false)
    private Aereopuerto aereopuertoSalida;
    @JoinColumn(name = "tipo_producto", referencedColumnName = "codigo_tpr")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdaRs")
    private List<Reserva> reservaList;
    @OneToMany(mappedBy = "productoRetornoRs")
    private List<Reserva> reservaList1;

    public Producto() {
    }

    public Producto(Integer codigoPo) {
        this.codigoPo = codigoPo;
    }

    public Producto(Integer codigoPo, String nombrePo, double precioPo, String estadoPo, int usuarioActPo, Date fechaActPo) {
        this.codigoPo = codigoPo;
        this.nombrePo = nombrePo;
        this.precioPo = precioPo;
        this.estadoPo = estadoPo;
        this.usuarioActPo = usuarioActPo;
        this.fechaActPo = fechaActPo;
    }

    public Integer getCodigoPo() {
        return codigoPo;
    }

    public void setCodigoPo(Integer codigoPo) {
        this.codigoPo = codigoPo;
    }

    public String getNombrePo() {
        return nombrePo;
    }

    public void setNombrePo(String nombrePo) {
        this.nombrePo = nombrePo;
    }

    public double getPrecioPo() {
        return precioPo;
    }

    public void setPrecioPo(double precioPo) {
        this.precioPo = precioPo;
    }

    public String getEstadoPo() {
        return estadoPo;
    }

    public void setEstadoPo(String estadoPo) {
        this.estadoPo = estadoPo;
    }

    public int getUsuarioActPo() {
        return usuarioActPo;
    }

    public void setUsuarioActPo(int usuarioActPo) {
        this.usuarioActPo = usuarioActPo;
    }

    public Date getFechaActPo() {
        return fechaActPo;
    }

    public void setFechaActPo(Date fechaActPo) {
        this.fechaActPo = fechaActPo;
    }

    public Aereolinea getAereolinea() {
        return aereolinea;
    }

    public void setAereolinea(Aereolinea aereolinea) {
        this.aereolinea = aereolinea;
    }

    public Aereopuerto getAereopuertoLlegada() {
        return aereopuertoLlegada;
    }

    public void setAereopuertoLlegada(Aereopuerto aereopuertoLlegada) {
        this.aereopuertoLlegada = aereopuertoLlegada;
    }

    public Aereopuerto getAereopuertoSalida() {
        return aereopuertoSalida;
    }

    public void setAereopuertoSalida(Aereopuerto aereopuertoSalida) {
        this.aereopuertoSalida = aereopuertoSalida;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @XmlTransient
    public List<Reserva> getReservaList1() {
        return reservaList1;
    }

    public void setReservaList1(List<Reserva> reservaList1) {
        this.reservaList1 = reservaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPo != null ? codigoPo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoPo == null && other.codigoPo != null) || (this.codigoPo != null && !this.codigoPo.equals(other.codigoPo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Producto[ codigoPo=" + codigoPo + " ]";
    }
    
}
