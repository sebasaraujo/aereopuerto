/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.ProductoVuelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ProductoVueloFacadeLocal {

    void create(ProductoVuelo productoVuelo);

    void edit(ProductoVuelo productoVuelo);

    void remove(ProductoVuelo productoVuelo);

    ProductoVuelo find(Object id);

    List<ProductoVuelo> findAll();

    List<ProductoVuelo> findRange(int[] range);

    int count();
    
}
