/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Producto;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ProductoFacadeLocal {

    void create(Producto producto);

    void edit(Producto producto);

    void remove(Producto producto);

    Producto find(Object id);

    List<Producto> findAll();

    List<Producto> findRange(int[] range);

    int count();

    /**
     * Metodo que busca productos segun sus parametros
     * @param codigoAereopuertoSalida
     * @param codigoAereopuertoLlegada
     * @param fecha
     * @return
     */
	List<Producto> obtenerProductosBusqueda(Integer codigoAereopuertoSalida, Integer codigoAereopuertoLlegada, Date fecha, Integer tipoCabina);

	
	/**
	 * Metodo que obtiene el producto
	 * @param codigo
	 * @return
	 */
	Producto obtenerProductoXId(Integer codigo);
    
}
