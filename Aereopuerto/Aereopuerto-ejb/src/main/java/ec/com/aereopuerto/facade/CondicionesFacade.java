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
import ec.com.aereopuerto.facade.local.CondicionesFacadeLocal;
import ec.com.aereopuerto.modelo.Condiciones;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class CondicionesFacade extends AbstractFacade<Condiciones> implements CondicionesFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CondicionesFacade() {
        super(Condiciones.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Condiciones> obtenerCondiciones()
    {
    	Query q = em.createQuery("Select c from Condiciones c where c.estadoCo = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
