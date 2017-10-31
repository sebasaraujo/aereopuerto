package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Condiciones;

@Local
public interface CondicionesService {

	/**
	 * Metodo que obtiene las condiciones
	 * @return
	 */
	List<Condiciones> obtenerCondiciones();

}
