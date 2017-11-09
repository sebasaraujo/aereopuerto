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

	/**
	 * Metodo que valida si exixte el numero de reserva
	 * @param numero
	 * @return
	 */
	boolean validarNumeroReserva(String numero);

}
