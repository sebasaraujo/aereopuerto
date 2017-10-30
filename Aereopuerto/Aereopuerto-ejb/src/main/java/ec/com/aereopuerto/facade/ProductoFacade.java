/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.ProductoFacadeLocal;
import ec.com.aereopuerto.modelo.Producto;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> implements ProductoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Producto> obtenerProductosBusqueda(Integer codigoAereopuertoSalida, Integer codigoAereopuertoLlegada, Date fecha)
    {
    	Query q = em.createQuery("Select distinct p from Producto p left join fetch p.productoVueloList pv left join fetch pv.vuelo v where p.aereopuertoLlegada.codigoAe = :codigoAereopuertoLlegada and p.aereopuertoSalida.codigoAe = :codigoAereopuertoSalida"
    			+ " and p.fechaPo = :fecha");
    	q.setParameter("codigoAereopuertoLlegada", codigoAereopuertoLlegada);
    	q.setParameter("codigoAereopuertoSalida", codigoAereopuertoSalida);
    	q.setParameter("fecha", fecha);
    	return q.getResultList();
    }
    
}
