package ec.com.aereopuerto.service.local;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.PasajeroReserva;

@Local
public interface PasajeroReservaService {

	/**
	 * Metodo que persiste un registro
	 * @param pasajeroReserva
	 */
	void crear(PasajeroReserva pasajeroReserva);

}
