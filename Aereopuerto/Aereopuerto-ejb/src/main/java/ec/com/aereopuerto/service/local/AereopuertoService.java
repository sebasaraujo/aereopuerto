package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Aereopuerto;

@Local
public interface AereopuertoService {

	/**
	 * Metodo que obtiene todos los aereopuertos activos
	 * @return
	 */
	List<Aereopuerto> obtenerAereopuertosActivos();

	/**
	 * Metodo que obtiene todos los aereopuertos excepto el destino seleccionado
	 * @param destino
	 * @return
	 */
	List<Aereopuerto> obtenerAereopuertosSinDestino(Integer destino);

	/**
	 * Metodo que obtiene el aereopuerto por id
	 * @param id
	 * @return
	 */
	Aereopuerto obtenerXId(Integer id);

}
