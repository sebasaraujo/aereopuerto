/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccion.findAll", query = "SELECT d FROM Direccion d")
    , @NamedQuery(name = "Direccion.findByCodigoDi", query = "SELECT d FROM Direccion d WHERE d.codigoDi = :codigoDi")
    , @NamedQuery(name = "Direccion.findByCallePrincipalDi", query = "SELECT d FROM Direccion d WHERE d.callePrincipalDi = :callePrincipalDi")
    , @NamedQuery(name = "Direccion.findByCalleSecundariaDi", query = "SELECT d FROM Direccion d WHERE d.calleSecundariaDi = :calleSecundariaDi")
    , @NamedQuery(name = "Direccion.findByNumeroDi", query = "SELECT d FROM Direccion d WHERE d.numeroDi = :numeroDi")
    , @NamedQuery(name = "Direccion.findByCodigoPostal", query = "SELECT d FROM Direccion d WHERE d.codigoPostal = :codigoPostal")})
public class Direccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_di")
    private Integer codigoDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "calle_principal_di")
    private String callePrincipalDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "calle_secundaria_di")
    private String calleSecundariaDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_di")
    private String numeroDi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccion")
    private List<Pasajero> pasajeroList;

    public Direccion() {
    }

    public Direccion(Integer codigoDi) {
        this.codigoDi = codigoDi;
    }

    public Direccion(Integer codigoDi, String callePrincipalDi, String calleSecundariaDi, String numeroDi, String codigoPostal) {
        this.codigoDi = codigoDi;
        this.callePrincipalDi = callePrincipalDi;
        this.calleSecundariaDi = calleSecundariaDi;
        this.numeroDi = numeroDi;
        this.codigoPostal = codigoPostal;
    }

    public Integer getCodigoDi() {
        return codigoDi;
    }

    public void setCodigoDi(Integer codigoDi) {
        this.codigoDi = codigoDi;
    }

    public String getCallePrincipalDi() {
        return callePrincipalDi;
    }

    public void setCallePrincipalDi(String callePrincipalDi) {
        this.callePrincipalDi = callePrincipalDi;
    }

    public String getCalleSecundariaDi() {
        return calleSecundariaDi;
    }

    public void setCalleSecundariaDi(String calleSecundariaDi) {
        this.calleSecundariaDi = calleSecundariaDi;
    }

    public String getNumeroDi() {
        return numeroDi;
    }

    public void setNumeroDi(String numeroDi) {
        this.numeroDi = numeroDi;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @XmlTransient
    public List<Pasajero> getPasajeroList() {
        return pasajeroList;
    }

    public void setPasajeroList(List<Pasajero> pasajeroList) {
        this.pasajeroList = pasajeroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDi != null ? codigoDi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.codigoDi == null && other.codigoDi != null) || (this.codigoDi != null && !this.codigoDi.equals(other.codigoDi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.aereopuerto.modelo.Direccion[ codigoDi=" + codigoDi + " ]";
    }
    
}
