/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.TarifaProductoFacadeLocal;
import ec.com.aereopuerto.modelo.TarifaProducto;

/**
 *
 * @author sebastian
 */
@Stateless
public class TarifaProductoFacade extends AbstractFacade<TarifaProducto> implements TarifaProductoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarifaProductoFacade() {
        super(TarifaProducto.class);
    }
    
    @Override
    public Double obtenerCostoMinimoProducto(Integer codigoProducto, Integer codigoCabina)
    {
    	try {
    		Query q = em.createQuery("Select min(tp.costoTp) from TarifaProducto tp where tp.producto.codigoPo = :codigoProducto and tp.tipoCabina.codigoTc = :codigoCabina and tp.estadoTp = :estado ");
        	q.setParameter("codigoProducto", codigoProducto);
        	q.setParameter("codigoCabina", codigoCabina);
        	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
        	return (Double) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
    	
    }
    
	@SuppressWarnings("unchecked")
	@Override
	public List<TarifaProducto> obtenerTarifaProductoXProductoCabina(Integer codigoProducto, Integer codigoCabina) {
		Query q = em.createQuery(
				"Select tp from TarifaProducto tp left join fetch tp.tipoTarifa tt left join fetch tp.tipoCabina tc where "
				+ "tp.producto.codigoPo = :codigoProducto and tp.tipoCabina.codigoTc = :codigoCabina and tp.estadoTp = :estado order by tp.tipoTarifa.codigoTt");
		q.setParameter("codigoProducto", codigoProducto);
		q.setParameter("codigoCabina", codigoCabina);
		q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
		return q.getResultList();

	}
	
	@Override
    public Double obtenerCostoProductoTarifaCabina(Integer codigoProducto, Integer codigoCabina, Integer codigoTarifa)
    {
    	try {
    		Query q = em.createQuery("Select tp.costoTp from TarifaProducto tp where tp.producto.codigoPo = :codigoProducto and tp.tipoCabina.codigoTc = :codigoCabina "
    				+ "and tp.estadoTp = :estado and tp.tipoTarifa.codigoTt = :codigoTarifa");
        	q.setParameter("codigoProducto", codigoProducto);
        	q.setParameter("codigoCabina", codigoCabina);
        	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
        	q.setParameter("codigoTarifa", codigoTarifa);
        	return (Double) q.getSingleResult();
		} catch (Exception e) {
			return 0.0;
		}
    	
    }
	
	
    
}
