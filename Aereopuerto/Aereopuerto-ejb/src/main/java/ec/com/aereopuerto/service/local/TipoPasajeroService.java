package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoPasajero;

@Local
public interface TipoPasajeroService {

	/**
	 * Metodo que obtiene todos los tipos de pasajeros activos
	 * @return
	 */
	List<TipoPasajero> obtenerTipoPasajeros();

}
