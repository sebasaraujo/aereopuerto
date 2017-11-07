package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.PaisFacadeLocal;
import ec.com.aereopuerto.modelo.Pais;
import ec.com.aereopuerto.service.local.PaisService;

@Stateless
public class PaisServiceImpl implements PaisService{

	@EJB
	private PaisFacadeLocal paisFacade;
	
	@Override
    public List<Pais> obtenerPaises()
    {
		return paisFacade.obtenerPaises();
    }
}
