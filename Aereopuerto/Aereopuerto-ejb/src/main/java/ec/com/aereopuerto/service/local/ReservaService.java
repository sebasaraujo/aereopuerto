package ec.com.aereopuerto.service.local;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Reserva;

@Local
public interface ReservaService {

	/**
	 * 
	 * @param reserva
	 */
	void crear(Reserva reserva);

}
