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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "pasajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p")
    , @NamedQuery(name = "Pasajero.findByCodigoPs", query = "SELECT p FROM Pasajero p WHERE p.codigoPs = :codigoPs")
    , @NamedQuery(name = "Pasajero.findByNombrePs", query = "SELECT p FROM Pasajero p WHERE p.nombrePs = :nombrePs")
    , @NamedQuery(name = "Pasajero.findByApellidoPs", query = "SELECT p FROM Pasajero p WHERE p.apellidoPs = :apellidoPs")
    , @NamedQuery(name = "Pasajero.findByIdentifiacionPs", query = "SELECT p FROM Pasajero p WHERE p.identifiacionPs = :identifiacionPs")
    , @NamedQuery(name = "Pasajero.findByCorreoPs", query = "SELECT p FROM Pasajero p WHERE p.correoPs = :correoPs")
    , @NamedQuery(name = "Pasajero.findByEstadoPs", query = "SELECT p FROM Pasajero p WHERE p.estadoPs = :estadoPs")
    , @NamedQuery(name = "Pasajero.findByUsuarioActPs", query = "SELECT p FROM Pasajero p WHERE p.usuarioActPs = :usuarioActPs")
    , @NamedQuery(name = "Pasajero.findByFechaActPs", query = "SELECT p FROM Pasajero p WHERE p.fechaActPs = :fechaActPs")})
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ps")
    private Integer codigoPs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_ps")
    private String nombrePs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido_ps")
    private String apellidoPs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "identifiacion_ps")
    private String identifiacionPs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_ps")
    private String correoPs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_ps")
    private String estadoPs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_ps")
    private int usuarioActPs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_ps")
    @Temporal(TemporalType.DATE)
    private Date fechaActPs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasajero")
    private List<PasajeroReserva> pasajeroReservaList;
    @JoinColumn(name = "direccion", referencedColumnName = "codigo_di")
    @ManyToOne(optional = false)
    private Direccion direccion;
    @JoinColumn(name = "tipo_identificacion", referencedColumnName = "codigo_ti")
    @ManyToOne(optional = false)
    private TipoIdentificacion tipoIdentificacion;
    @JoinColumn(name = "tipo_pasajero", referencedColumnName = "codigo_tp")
    @ManyToOne(optional = false)
    private TipoPasajero tipoPasajero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasajero")
    private List<ContactoPasajero> contactoPasajeroList;

    @Transient
    private Integer numeroPasajero;
    
    @Transient
    private Integer codigoTipoIdentificacion;
    
    public Pasajero() {
    }

    public Pasajero(Integer codigoPs) {
        this.codigoPs = codigoPs;
    }

    public Pasajero(Integer codigoPs, String nombrePs, String apellidoPs, String identifiacionPs, String correoPs, String estadoPs, int usuarioActPs, Date fechaActPs) {
        this.codigoPs = codigoPs;
        this.nombrePs = nombrePs;
        this.apellidoPs = apellidoPs;
        this.identifiacionPs = identifiacionPs;
        this.correoPs = correoPs;
        this.estadoPs = estadoPs;
        this.usuarioActPs = usuarioActPs;
        this.fechaActPs = fechaActPs;
    }

    public Integer getCodigoPs() {
        return codigoPs;
    }

    public void setCodigoPs(Integer codigoPs) {
        this.codigoPs = codigoPs;
    }

    public String getNombrePs() {
        return nombrePs;
    }

    public void setNombrePs(String nombrePs) {
        this.nombrePs = nombrePs;
    }

    public String getApellidoPs() {
        return apellidoPs;
    }

    public void setApellidoPs(String apellidoPs) {
        this.apellidoPs = apellidoPs;
    }

    public String getIdentifiacionPs() {
        return identifiacionPs;
    }

    public void setIdentifiacionPs(String identifiacionPs) {
        this.identifiacionPs = identifiacionPs;
    }

    public String getCorreoPs() {
        return correoPs;
    }

    public void setCorreoPs(String correoPs) {
        this.correoPs = correoPs;
    }

    public String getEstadoPs() {
        return estadoPs;
    }

    public void setEstadoPs(String estadoPs) {
        this.estadoPs = estadoPs;
    }

    public int getUsuarioActPs() {
        return usuarioActPs;
    }

    public void setUsuarioActPs(int usuarioActPs) {
        this.usuarioActPs = usuarioActPs;
    }

    public Date getFechaActPs() {
        return fechaActPs;
    }

    public void setFechaActPs(Date fechaActPs) {
        this.fechaActPs = fechaActPs;
    }

    @XmlTransient
    public List<PasajeroReserva> getPasajeroReservaList() {
        return pasajeroReservaList;
    }

    public void setPasajeroReservaList(List<PasajeroReserva> pasajeroReservaList) {
        this.pasajeroReservaList = pasajeroReservaList;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoPasajero getTipoPasajero() {
        return tipoPasajero;
    }

    public void setTipoPasajero(TipoPasajero tipoPasajero) {
        this.tipoPasajero = tipoPasajero;
    }

    @XmlTransient
    public List<ContactoPasajero> getContactoPasajeroList() {
        return contactoPasajeroList;
    }

    public void setContactoPasajeroList(List<ContactoPasajero> contactoPasajeroList) {
        this.contactoPasajeroList = contactoPasajeroList;
    }

    public Integer getNumeroPasajero() {
		return numeroPasajero;
	}

	public void setNumeroPasajero(Integer numeroPasajero) {
		this.numeroPasajero = numeroPasajero;
	}

	public Integer getCodigoTipoIdentificacion() {
		return codigoTipoIdentificacion;
	}

	public void setCodigoTipoIdentificacion(Integer codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPs != null ? codigoPs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasajero)) {
            return false;
        }
        Pasajero other = (Pasajero) object;
        if ((this.codigoPs == null && other.codigoPs != null) || (this.codigoPs != null && !this.codigoPs.equals(other.codigoPs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Pasajero[ codigoPs=" + codigoPs + " ]";
    }
    
}
