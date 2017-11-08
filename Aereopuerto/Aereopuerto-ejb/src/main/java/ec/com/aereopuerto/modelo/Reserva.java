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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByCodigoRs", query = "SELECT r FROM Reserva r WHERE r.codigoRs = :codigoRs")
    , @NamedQuery(name = "Reserva.findByFechaSalida", query = "SELECT r FROM Reserva r WHERE r.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Reserva.findByFechaRetorno", query = "SELECT r FROM Reserva r WHERE r.fechaRetorno = :fechaRetorno")
    , @NamedQuery(name = "Reserva.findByNumeroRs", query = "SELECT r FROM Reserva r WHERE r.numeroRs = :numeroRs")
    , @NamedQuery(name = "Reserva.findByEstadoRs", query = "SELECT r FROM Reserva r WHERE r.estadoRs = :estadoRs")
    , @NamedQuery(name = "Reserva.findByUsuarioActRs", query = "SELECT r FROM Reserva r WHERE r.usuarioActRs = :usuarioActRs")
    , @NamedQuery(name = "Reserva.findByFechaActRs", query = "SELECT r FROM Reserva r WHERE r.fechaActRs = :fechaActRs")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_rs")
    private Integer codigoRs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Column(name = "fecha_retorno")
    @Temporal(TemporalType.DATE)
    private Date fechaRetorno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_rs")
    private String numeroRs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_rs")
    private String estadoRs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_rs")
    private int usuarioActRs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_rs")
    @Temporal(TemporalType.DATE)
    private Date fechaActRs;
    @Column(name = "costo_total_rs")
    private Double costoTotalRs;
    @JoinColumn(name = "producto_ida_rs", referencedColumnName = "codigo_po")
    @ManyToOne(optional = false)
    private Producto productoIdaRs;
    @JoinColumn(name = "producto_retorno_rs", referencedColumnName = "codigo_po")
    @ManyToOne
    private Producto productoRetornoRs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private List<PasajeroReserva> pasajeroReservaList;
    @JoinColumn(name = "desde_rs", referencedColumnName = "codigo_ae")
    @ManyToOne(optional = false)
    private Aereopuerto desdeRs;
    @JoinColumn(name = "hacia_rs", referencedColumnName = "codigo_ae")
    @ManyToOne(optional = false)
    private Aereopuerto haciaRs;
    @JoinColumn(name = "tipo_reserva", referencedColumnName = "codigo_tr")
    @ManyToOne(optional = false)
    private TipoReserva tipoReserva;
    @JoinColumn(name = "tipo_cabina", referencedColumnName = "codigo_tc")
    @ManyToOne(optional = false)
    private TipoCabina tipoCabina;
    @JoinColumn(name = "tipo_tarifa_ida", referencedColumnName = "codigo_tt")
    @ManyToOne(optional = false)
    private TipoTarifa tipoTarifaIda;
    @JoinColumn(name = "tipo_tarifa_regreso", referencedColumnName = "codigo_tt")
    @ManyToOne(optional = false)
    private TipoTarifa tipoTarifaRegreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
    private List<PasajeroCosto> pasajeroCosto;
    

    public Reserva() {
    }

    public Reserva(Integer codigoRs) {
        this.codigoRs = codigoRs;
    }

    public Reserva(Integer codigoRs, Date fechaSalida, Date fechaRetorno, String numeroRs, String estadoRs, int usuarioActRs, Date fechaActRs) {
        this.codigoRs = codigoRs;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.numeroRs = numeroRs;
        this.estadoRs = estadoRs;
        this.usuarioActRs = usuarioActRs;
        this.fechaActRs = fechaActRs;
    }

    public Integer getCodigoRs() {
        return codigoRs;
    }

    public void setCodigoRs(Integer codigoRs) {
        this.codigoRs = codigoRs;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getNumeroRs() {
        return numeroRs;
    }

    public void setNumeroRs(String numeroRs) {
        this.numeroRs = numeroRs;
    }

    public String getEstadoRs() {
        return estadoRs;
    }

    public void setEstadoRs(String estadoRs) {
        this.estadoRs = estadoRs;
    }

    public int getUsuarioActRs() {
        return usuarioActRs;
    }

    public void setUsuarioActRs(int usuarioActRs) {
        this.usuarioActRs = usuarioActRs;
    }

    public Date getFechaActRs() {
        return fechaActRs;
    }

    public void setFechaActRs(Date fechaActRs) {
        this.fechaActRs = fechaActRs;
    }

    @XmlTransient
    public List<PasajeroReserva> getPasajeroReservaList() {
        return pasajeroReservaList;
    }

    public void setPasajeroReservaList(List<PasajeroReserva> pasajeroReservaList) {
        this.pasajeroReservaList = pasajeroReservaList;
    }

    public Aereopuerto getDesdeRs() {
        return desdeRs;
    }

    public void setDesdeRs(Aereopuerto desdeRs) {
        this.desdeRs = desdeRs;
    }

    public Aereopuerto getHaciaRs() {
        return haciaRs;
    }

    public void setHaciaRs(Aereopuerto haciaRs) {
        this.haciaRs = haciaRs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoRs != null ? codigoRs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codigoRs == null && other.codigoRs != null) || (this.codigoRs != null && !this.codigoRs.equals(other.codigoRs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Reserva[ codigoRs=" + codigoRs + " ]";
    }

    public Producto getProductoIdaRs() {
        return productoIdaRs;
    }

    public void setProductoIdaRs(Producto productoIdaRs) {
        this.productoIdaRs = productoIdaRs;
    }

    public Producto getProductoRetornoRs() {
        return productoRetornoRs;
    }

    public void setProductoRetornoRs(Producto productoRetornoRs) {
        this.productoRetornoRs = productoRetornoRs;
    }

	public TipoReserva getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(TipoReserva tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public TipoCabina getTipoCabina() {
		return tipoCabina;
	}

	public void setTipoCabina(TipoCabina tipoCabina) {
		this.tipoCabina = tipoCabina;
	}

	public TipoTarifa getTipoTarifaIda() {
		return tipoTarifaIda;
	}

	public void setTipoTarifaIda(TipoTarifa tipoTarifaIda) {
		this.tipoTarifaIda = tipoTarifaIda;
	}

	public TipoTarifa getTipoTarifaRegreso() {
		return tipoTarifaRegreso;
	}

	public void setTipoTarifaRegreso(TipoTarifa tipoTarifaRegreso) {
		this.tipoTarifaRegreso = tipoTarifaRegreso;
	}

	public List<PasajeroCosto> getPasajeroCosto() {
		return pasajeroCosto;
	}

	public void setPasajeroCosto(List<PasajeroCosto> pasajeroCosto) {
		this.pasajeroCosto = pasajeroCosto;
	}

	public Double getCostoTotalRs() {
		return costoTotalRs;
	}

	public void setCostoTotalRs(Double costoTotalRs) {
		this.costoTotalRs = costoTotalRs;
	}
    
}
