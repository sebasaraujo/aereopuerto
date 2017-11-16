package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.ProductoVuelo;

@Local
public interface ProductoVueloService {

	/**
	 * Metodo que obtiene el producto vuelo por producto
	 * @param producto
	 * @return
	 */
	List<ProductoVuelo> obtenerProductoVueloXProducto(Integer producto);

}
