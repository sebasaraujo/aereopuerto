package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Pais;

@Local
public interface PaisService {

	/**
	 * Metodo que obtiene todos los paises
	 * @return
	 */
	List<Pais> obtenerPaises();

}
