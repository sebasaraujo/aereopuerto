package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoIdentificacionFacadeLocal;
import ec.com.aereopuerto.modelo.TipoIdentificacion;
import ec.com.aereopuerto.service.local.TipoIdentificacionService;

@Stateless
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@EJB
	private TipoIdentificacionFacadeLocal tipoIdentificacionFacade;

	@Override
	public List<TipoIdentificacion> obtenerTipoIdentificacion() {
		return tipoIdentificacionFacade.obtenerTipoIdentificacion();
	}

}
