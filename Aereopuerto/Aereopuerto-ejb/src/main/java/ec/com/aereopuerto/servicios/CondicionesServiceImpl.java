package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.CondicionesFacadeLocal;
import ec.com.aereopuerto.modelo.Condiciones;
import ec.com.aereopuerto.service.local.CondicionesService;

@Stateless
public class CondicionesServiceImpl implements CondicionesService{

	@EJB
	private CondicionesFacadeLocal condicionesFacade;
	
	@Override
    public List<Condiciones> obtenerCondiciones()
    {
		return condicionesFacade.obtenerCondiciones();
    }
	
}
