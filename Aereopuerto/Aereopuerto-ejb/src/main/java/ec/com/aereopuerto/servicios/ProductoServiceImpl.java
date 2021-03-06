package ec.com.aereopuerto.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.ProductoFacadeLocal;
import ec.com.aereopuerto.modelo.Producto;
import ec.com.aereopuerto.service.local.ProductoService;

@Stateless
public class ProductoServiceImpl implements ProductoService{

	@EJB
	private ProductoFacadeLocal productoFacade;
	
	@Override
    public List<Producto> obtenerProductosBusqueda(Integer codigoAereopuertoSalida, Integer codigoAereopuertoLlegada, Date fecha, Integer tipoCabina)
    {
		return productoFacade.obtenerProductosBusqueda(codigoAereopuertoSalida, codigoAereopuertoLlegada, fecha, tipoCabina);
    }
	
	@Override
	public Producto obtenerXId(Integer codigo)
	{
		return productoFacade.obtenerProductoXId(codigo);
	}
	
}
