package ec.com.aereopuerto.service.local;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoTarifa;

@Local
public interface TipoTarifaService {

	/**
	 * Metodo que obtiene el tipo de tarifa
	 * @param codigo
	 * @return
	 */
	TipoTarifa obtenerXId(Integer codigo);

}
