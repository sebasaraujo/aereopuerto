package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoReserva;

@Local
public interface TipoReservaService {

	/**
	 * Metodo que obtiene todas los tipos de reserva activos
	 * @return
	 */
	List<TipoReserva> obtenerTiposReservasActivas();

}
