package ec.com.aereopuerto.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.aereopuerto.facade.local.ProductoVueloFacadeLocal;
import ec.com.aereopuerto.modelo.ProductoVuelo;
import ec.com.aereopuerto.service.local.ProductoVueloService;

@Stateless
public class ProductoVueloServiceImpl implements ProductoVueloService {

	@EJB
	private ProductoVueloFacadeLocal productoVueloFacade;
	
	@Override
    public List<ProductoVuelo> obtenerProductoVueloXProducto(Integer producto)
    {
		return productoVueloFacade.obtenerProductoVueloXProducto(producto);
    }
	
}
