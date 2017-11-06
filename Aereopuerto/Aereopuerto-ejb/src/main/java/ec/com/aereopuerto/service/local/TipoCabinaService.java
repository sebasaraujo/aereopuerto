package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoCabina;

@Local
public interface TipoCabinaService {

	/**
	 * Metodo que obtiene todos los tipos de cabina activos
	 * @return
	 */
	List<TipoCabina> obtenerTipoCabinasActivo();

	/**
	 * Metodo que obtiene el tipo cabina por id
	 * @param codigo
	 * @return
	 */
	TipoCabina obtenerXId(Integer codigo);

}
