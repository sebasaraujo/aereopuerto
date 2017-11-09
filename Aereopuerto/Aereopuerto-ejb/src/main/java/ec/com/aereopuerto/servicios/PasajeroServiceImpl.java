package ec.com.aereopuerto.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.PasajeroFacadeLocal;
import ec.com.aereopuerto.modelo.Pasajero;
import ec.com.aereopuerto.service.local.PasajeroService;

@Stateless
public class PasajeroServiceImpl implements PasajeroService{

	@EJB
	private PasajeroFacadeLocal pasajeroFacade;
	
	@Override
	public void crear(Pasajero pasajero)
	{
		pasajeroFacade.create(pasajero);
	}
	
}
