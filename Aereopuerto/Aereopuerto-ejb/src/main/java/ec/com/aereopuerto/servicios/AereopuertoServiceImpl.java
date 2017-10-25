package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.AereopuertoFacadeLocal;
import ec.com.aereopuerto.modelo.Aereopuerto;
import ec.com.aereopuerto.service.local.AereopuertoService;

@Stateless
public class AereopuertoServiceImpl implements AereopuertoService{

	@EJB
	private AereopuertoFacadeLocal aereopuertoFacade;
	
	@Override
    public List<Aereopuerto> obtenerAereopuertosActivos()
    {
		return aereopuertoFacade.obtenerAereopuertosActivos();
    }
	
	@Override
    public List<Aereopuerto> obtenerAereopuertosSinDestino(Integer destino)
    {
		return aereopuertoFacade.obtenerAereopuertosSinDestino(destino);
    }
	
	@Override
	public Aereopuerto obtenerXId(Integer id)
	{
		return aereopuertoFacade.find(id);
	}
}
