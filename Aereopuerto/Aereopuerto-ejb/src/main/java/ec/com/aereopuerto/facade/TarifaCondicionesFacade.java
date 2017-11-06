/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.TarifaCondicionesFacadeLocal;
import ec.com.aereopuerto.modelo.TarifaCondiciones;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class TarifaCondicionesFacade extends AbstractFacade<TarifaCondiciones> implements TarifaCondicionesFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarifaCondicionesFacade() {
        super(TarifaCondiciones.class);
    }
    
    @Override
    public TarifaCondiciones obtenerTarifaCondiciones(Integer codigoCondicion, Integer codigoTarifa)
    {
    	try {
    		Query q = em.createQuery("Select tc from TarifaCondiciones tc left join fetch tc.condicion c left join fetch tc.tipoTarifa tt where tc.estadoTc = :estado "
        			+ "and c.codigoCo = :codigoCondicion and tt.codigoTt = :codigoTarifa");
        	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
        	q.setParameter("codigoCondicion", codigoCondicion);
        	q.setParameter("codigoTarifa", codigoTarifa);
        	return (TarifaCondiciones) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
    	
    }
    
}
