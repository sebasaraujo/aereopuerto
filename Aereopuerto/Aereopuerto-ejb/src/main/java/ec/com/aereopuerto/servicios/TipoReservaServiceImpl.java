package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.TipoReservaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoReserva;
import ec.com.aereopuerto.service.local.TipoReservaService;

@Stateless
public class TipoReservaServiceImpl implements TipoReservaService{
	
	@EJB
	private TipoReservaFacadeLocal tipoReservaFacade;

	@Override
    public List<TipoReserva> obtenerTiposReservasActivas()
    {
		return tipoReservaFacade.obtenerTiposReservasActivas();
    }
	
	@Override
	public TipoReserva obtenerXId(Integer codigo)
	{
		return tipoReservaFacade.find(codigo);
	}
	
}
