/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TarifaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TarifaProductoFacadeLocal {

    void create(TarifaProducto tarifaProducto);

    void edit(TarifaProducto tarifaProducto);

    void remove(TarifaProducto tarifaProducto);

    TarifaProducto find(Object id);

    List<TarifaProducto> findAll();

    List<TarifaProducto> findRange(int[] range);

    int count();
    
}
