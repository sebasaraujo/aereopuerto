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
import ec.com.aereopuerto.facade.local.TipoCabinaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoCabina;

/**
 *
 * @author sebastian
 */
@Stateless
public class TipoCabinaFacade extends AbstractFacade<TipoCabina> implements TipoCabinaFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCabinaFacade() {
        super(TipoCabina.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoCabina> obtenerTipoCabinasActivo()
    {
    	Query q = em.createQuery("Select tc from TipoCabina tc where tc.estadoTc = :estado order by tc.codigoTc");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
