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
    public List<Producto> obtenerProductosBusqueda(Integer codigoAereopuertoSalida, Integer codigoAereopuertoLlegada, Date fecha, Integer tipoCabina)
    {
    	Query q = em.createQuery("Select distinct p from Producto p left join fetch p.productoVueloList pv left join fetch pv.vuelo v, TarifaProducto tp "
    			+ "where tp.producto.codigoPo = p.codigoPo and p.aereopuertoLlegada.codigoAe = :codigoAereopuertoLlegada and p.aereopuertoSalida.codigoAe = :codigoAereopuertoSalida"
    			+ " and p.fechaPo = :fecha and tp.tipoCabina.codigoTc = :tipoCabina");
    	q.setParameter("codigoAereopuertoLlegada", codigoAereopuertoLlegada);
    	q.setParameter("codigoAereopuertoSalida", codigoAereopuertoSalida);
    	q.setParameter("fecha", fecha);
    	q.setParameter("tipoCabina", tipoCabina);
    	return q.getResultList();
    }
    
    @Override
    public Producto obtenerProductoXId(Integer codigo)
    {
    	try {
    		Query q = em.createQuery("Select p from Producto p left join fetch p.productoVueloList pv left join fetch pv.vuelo v "
        			+ "where p.codigoPo = :codigo");
        	q.setParameter("codigo", codigo);
        	return (Producto)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
    }
    
}
