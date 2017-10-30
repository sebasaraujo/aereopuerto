/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian
 */
@Entity
@Table(name = "producto_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoVuelo.findAll", query = "SELECT p FROM ProductoVuelo p")
    , @NamedQuery(name = "ProductoVuelo.findByCodigoPv", query = "SELECT p FROM ProductoVuelo p WHERE p.codigoPv = :codigoPv")})
public class ProductoVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pv")
    private Integer codigoPv;
    @JoinColumn(name = "producto", referencedColumnName = "codigo_po")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "vuelo", referencedColumnName = "codigo_vu")
    @ManyToOne(optional = false)
    private Vuelo vuelo;

    public ProductoVuelo() {
    }

    public ProductoVuelo(Integer codigoPv) {
        this.codigoPv = codigoPv;
    }

    public Integer getCodigoPv() {
        return codigoPv;
    }

    public void setCodigoPv(Integer codigoPv) {
        this.codigoPv = codigoPv;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPv != null ? codigoPv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoVuelo)) {
            return false;
        }
        ProductoVuelo other = (ProductoVuelo) object;
        if ((this.codigoPv == null && other.codigoPv != null) || (this.codigoPv != null && !this.codigoPv.equals(other.codigoPv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProductoVuelo[ codigoPv=" + codigoPv + " ]";
    }
    
}
