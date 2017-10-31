package ec.com.aereopuerto.service.local;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TarifaCondiciones;

@Local
public interface TarifaCondicionesService {

	/**
	 * Metodo que obtiene la tarifa condiciones
	 * @param codigoCondicion
	 * @param codigoTarifa
	 * @return
	 */
	TarifaCondiciones obtenerTarifaCondiciones(Integer codigoCondicion, Integer codigoTarifa);

}
