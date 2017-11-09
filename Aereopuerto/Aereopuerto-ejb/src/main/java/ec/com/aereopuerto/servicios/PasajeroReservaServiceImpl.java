package ec.com.aereopuerto.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.PasajeroReservaFacadeLocal;
import ec.com.aereopuerto.modelo.PasajeroReserva;
import ec.com.aereopuerto.service.local.PasajeroReservaService;

@Stateless
public class PasajeroReservaServiceImpl implements PasajeroReservaService{

	@EJB
	private PasajeroReservaFacadeLocal pasajeroReservaFacade;
	
	@Override
	public void crear(PasajeroReserva pasajeroReserva)
	{
		pasajeroReservaFacade.create(pasajeroReserva);
	}
	
}
