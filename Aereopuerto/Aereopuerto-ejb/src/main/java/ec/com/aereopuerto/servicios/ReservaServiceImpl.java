package ec.com.aereopuerto.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.ReservaFacadeLocal;
import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.service.local.ReservaService;

@Stateless
public class ReservaServiceImpl implements ReservaService{

	@EJB
	private ReservaFacadeLocal reservaFacade;
	
	@Override
	public void crear(Reserva reserva)
	{
		reservaFacade.create(reserva);
	}
	
	@Override
    public boolean validarNumeroReserva(String numero)
    {
		return reservaFacade.validarNumeroReserva(numero);
    }
	
}
