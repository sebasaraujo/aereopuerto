package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoPasajeroFacadeLocal;
import ec.com.aereopuerto.modelo.TipoPasajero;
import ec.com.aereopuerto.service.local.TipoPasajeroService;

@Stateless
public class TipoPasajeroServiceImpl implements TipoPasajeroService{

	@EJB
	private TipoPasajeroFacadeLocal tipoPasajeroFacade;
	
	@Override
    public List<TipoPasajero> obtenerTipoPasajeros()
    {
		return tipoPasajeroFacade.obtenerTipoPasajeros();
    }
	
}
