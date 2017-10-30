package ec.com.aereopuerto.service.local;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Producto;

@Local
public interface ProductoService {

	/**
	 * Metodo que obtiene prodcutos segun los parametros
	 * @param codigoAereopuertoSalida
	 * @param codigoAereopuertoLlegada
	 * @param fecha
	 * @return
	 */
	List<Producto> obtenerProductosBusqueda(Integer codigoAereopuertoSalida, Integer codigoAereopuertoLlegada, Date fecha);

}
