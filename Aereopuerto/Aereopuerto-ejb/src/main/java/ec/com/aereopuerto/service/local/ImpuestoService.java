package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Impuesto;

@Local
public interface ImpuestoService {

	/**
	 * Metodo que obtiene todos los impuestos activos
	 * @return
	 */
	List<Impuesto> obtenerTodos();

}
