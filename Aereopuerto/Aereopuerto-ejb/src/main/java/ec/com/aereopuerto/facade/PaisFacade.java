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
import ec.com.aereopuerto.facade.local.PaisFacadeLocal;
import ec.com.aereopuerto.modelo.Pais;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Pais> obtenerPaises()
    {
    	Query q = em.createQuery("Select p from Pais p where p.estadoPa = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
