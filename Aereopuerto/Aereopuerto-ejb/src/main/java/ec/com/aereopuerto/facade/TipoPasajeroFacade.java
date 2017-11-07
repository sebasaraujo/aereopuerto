/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.TipoPasajeroFacadeLocal;
import ec.com.aereopuerto.modelo.TipoPasajero;

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
public class TipoPasajeroFacade extends AbstractFacade<TipoPasajero> implements TipoPasajeroFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPasajeroFacade() {
        super(TipoPasajero.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoPasajero> obtenerTipoPasajeros()
    {
    	Query q = em.createQuery("Select tp from TipoPasajero tp where tp.estadoTp = :estado order by tp.codigoTp");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
}
