package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoImpuestoFacadeLocal;
import ec.com.aereopuerto.modelo.TipoImpuesto;
import ec.com.aereopuerto.service.local.TipoImpuestoService;

@Stateless
public class TipoImpuestoServiceImpl implements TipoImpuestoService{

	@EJB
	private TipoImpuestoFacadeLocal tipoImpuestoFacade;
	
	@Override
    public List<TipoImpuesto> obtenerTodosTiposImpuestos()
    {
		return tipoImpuestoFacade.obtenerTodosTiposImpuestos();
    }
	
}
