package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoCabinaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoCabina;
import ec.com.aereopuerto.service.local.TipoCabinaService;

@Stateless
public class TipoCabinaServiceImpl implements TipoCabinaService{

	@EJB
	private TipoCabinaFacadeLocal tipoCabinaFacade;
	
	@Override
    public List<TipoCabina> obtenerTipoCabinasActivo()
    {
		return tipoCabinaFacade.obtenerTipoCabinasActivo();
    }
	
}
