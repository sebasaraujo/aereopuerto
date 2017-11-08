package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoIdentificacion;

@Local
public interface TipoIdentificacionService {

	/**
	 * Metodo que obtiene todos los tipos de identificacion activos
	 * @return
	 */
	List<TipoIdentificacion> obtenerTipoIdentificacion();

}