package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.ImpuestoFacadeLocal;
import ec.com.aereopuerto.modelo.Impuesto;
import ec.com.aereopuerto.service.local.ImpuestoService;

@Stateless
public class ImpuestoServiceImpl implements ImpuestoService{

	@EJB
	private ImpuestoFacadeLocal impuestoFacade;
	
	@Override
    public List<Impuesto> obtenerTodos()
    {
		return impuestoFacade.obtenerTodos();
    }
}
