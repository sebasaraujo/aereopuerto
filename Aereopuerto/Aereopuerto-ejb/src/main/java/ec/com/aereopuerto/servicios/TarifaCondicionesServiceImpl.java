package ec.com.aereopuerto.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TarifaCondicionesFacadeLocal;
import ec.com.aereopuerto.modelo.TarifaCondiciones;
import ec.com.aereopuerto.service.local.TarifaCondicionesService;

@Stateless
public class TarifaCondicionesServiceImpl implements TarifaCondicionesService{

	@EJB
	private TarifaCondicionesFacadeLocal tarifaCondicionesFacade;
	
	@Override
    public TarifaCondiciones obtenerTarifaCondiciones(Integer codigoCondicion, Integer codigoTarifa)
    {
		return tarifaCondicionesFacade.obtenerTarifaCondiciones(codigoCondicion, codigoTarifa);
    }
	
}
