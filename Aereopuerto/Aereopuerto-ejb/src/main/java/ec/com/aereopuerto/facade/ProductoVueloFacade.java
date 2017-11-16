/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.ProductoVueloFacadeLocal;
import ec.com.aereopuerto.modelo.ProductoVuelo;

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
public class ProductoVueloFacade extends AbstractFacade<ProductoVuelo> implements ProductoVueloFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoVueloFacade() {
        super(ProductoVuelo.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<ProductoVuelo> obtenerProductoVueloXProducto(Integer producto)
    {
    	Query q = em.createQuery("Select pv from ProductoVuelo pv left join fetch pv.vuelo v where pv.producto.codigoPo = :producto");
    	q.setParameter("producto", producto);
    	return q.getResultList();
    	
    }
    
}
