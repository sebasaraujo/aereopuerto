package ec.com.aereopuerto.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoTarifaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoTarifa;
import ec.com.aereopuerto.service.local.TipoTarifaService;

@Stateless
public class TipoTarifaServiceImpl implements TipoTarifaService{

	@EJB
	private TipoTarifaFacadeLocal tipoTarifaFacade;
	
	@Override
	public TipoTarifa obtenerXId(Integer codigo)
	{
		return tipoTarifaFacade.find(codigo);
	}
	
}
