package ec.com.aereopuerto.service.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.TarifaProducto;

@Local
public interface TarifaProductoService {

	/**
	 * Metodo que obtiene el costo minimo de un producto
	 * @param codigoProducto
	 * @param codigoCabina
	 * @return
	 */
	Double obtenerCostoMinimoProducto(Integer codigoProducto, Integer codigoCabina);

	/**
	 * Metodo que obtiene las tarifas de un producto
	 * @param codigoProducto
	 * @param codigoCabina
	 * @return
	 */
	List<TarifaProducto> obtenerTarifaProductoXProductoCabina(Integer codigoProducto, Integer codigoCabina);

	/**
	 * Metodo que obtiene el costo del producto
	 * @param codigoProducto
	 * @param codigoCabina
	 * @param codigoTarifa
	 * @return
	 */
	Double obtenerCostoProductoTarifaCabina(Integer codigoProducto, Integer codigoCabina, Integer codigoTarifa);

}
