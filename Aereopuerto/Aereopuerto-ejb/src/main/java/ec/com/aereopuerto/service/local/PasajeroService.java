package ec.com.aereopuerto.service.local;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Pasajero;

@Local
public interface PasajeroService {

	/**
	 * Metodo que persiste un registro
	 * @param pasajero
	 */
	void crear(Pasajero pasajero);

}
