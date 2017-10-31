package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TarifaProductoFacadeLocal;
import ec.com.aereopuerto.modelo.TarifaProducto;
import ec.com.aereopuerto.service.local.TarifaProductoService;

@Stateless
public class TarifaProductoServiceImpl implements TarifaProductoService{

	@EJB
	private TarifaProductoFacadeLocal tarifaProductoFacade;
	
	@Override
	public Double obtenerCostoMinimoProducto(Integer codigoProducto, Integer codigoCabina)
    {
		return tarifaProductoFacade.obtenerCostoMinimoProducto(codigoProducto, codigoCabina);
    }
	
	@Override
	public List<TarifaProducto> obtenerTarifaProductoXProductoCabina(Integer codigoProducto, Integer codigoCabina) {
		return tarifaProductoFacade.obtenerTarifaProductoXProductoCabina(codigoProducto, codigoCabina);
	}
	
	@Override
    public Double obtenerCostoProductoTarifaCabina(Integer codigoProducto, Integer codigoCabina, Integer codigoTarifa)
    {
		return tarifaProductoFacade.obtenerCostoProductoTarifaCabina(codigoProducto, codigoCabina, codigoTarifa);
    }
	
}
