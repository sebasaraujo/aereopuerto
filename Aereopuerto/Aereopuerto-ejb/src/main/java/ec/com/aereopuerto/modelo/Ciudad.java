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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCodigoCi", query = "SELECT c FROM Ciudad c WHERE c.codigoCi = :codigoCi")
    , @NamedQuery(name = "Ciudad.findByNombreCi", query = "SELECT c FROM Ciudad c WHERE c.nombreCi = :nombreCi")
    , @NamedQuery(name = "Ciudad.findByEstadoCi", query = "SELECT c FROM Ciudad c WHERE c.estadoCi = :estadoCi")
    , @NamedQuery(name = "Ciudad.findByUsuarioActCi", query = "SELECT c FROM Ciudad c WHERE c.usuarioActCi = :usuarioActCi")
    , @NamedQuery(name = "Ciudad.findByFechaActCi", query = "SELECT c FROM Ciudad c WHERE c.fechaActCi = :fechaActCi")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ci")
    private Integer codigoCi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_ci")
    private String nombreCi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado_ci")
    private String estadoCi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_act_ci")
    private int usuarioActCi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_act_ci")
    @Temporal(TemporalType.DATE)
    private Date fechaActCi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Aereopuerto> aereopuertoList;
    @JoinColumn(name = "pais", referencedColumnName = "codigo_pa")
    @ManyToOne(optional = false)
    private Pais pais;

    public Ciudad() {
    }

    public Ciudad(Integer codigoCi) {
        this.codigoCi = codigoCi;
    }

    public Ciudad(Integer codigoCi, String nombreCi, String estadoCi, int usuarioActCi, Date fechaActCi) {
        this.codigoCi = codigoCi;
        this.nombreCi = nombreCi;
        this.estadoCi = estadoCi;
        this.usuarioActCi = usuarioActCi;
        this.fechaActCi = fechaActCi;
    }

    public Integer getCodigoCi() {
        return codigoCi;
    }

    public void setCodigoCi(Integer codigoCi) {
        this.codigoCi = codigoCi;
    }

    public String getNombreCi() {
        return nombreCi;
    }

    public void setNombreCi(String nombreCi) {
        this.nombreCi = nombreCi;
    }

    public String getEstadoCi() {
        return estadoCi;
    }

    public void setEstadoCi(String estadoCi) {
        this.estadoCi = estadoCi;
    }

    public int getUsuarioActCi() {
        return usuarioActCi;
    }

    public void setUsuarioActCi(int usuarioActCi) {
        this.usuarioActCi = usuarioActCi;
    }

    public Date getFechaActCi() {
        return fechaActCi;
    }

    public void setFechaActCi(Date fechaActCi) {
        this.fechaActCi = fechaActCi;
    }

    @XmlTransient
    public List<Aereopuerto> getAereopuertoList() {
        return aereopuertoList;
    }

    public void setAereopuertoList(List<Aereopuerto> aereopuertoList) {
        this.aereopuertoList = aereopuertoList;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCi != null ? codigoCi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigoCi == null && other.codigoCi != null) || (this.codigoCi != null && !this.codigoCi.equals(other.codigoCi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Ciudad[ codigoCi=" + codigoCi + " ]";
    }
    
}
