package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TipoImpuesto;

@Local
public interface TipoImpuestoService {

	/**
	 * Metodo que obtiene todos los tipos de impuestos activos
	 * @return
	 */
	List<TipoImpuesto> obtenerTodosTiposImpuestos();

}
