/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.TipoReservaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoReserva;

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
public class TipoReservaFacade extends AbstractFacade<TipoReserva> implements TipoReservaFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReservaFacade() {
        super(TipoReserva.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoReserva> obtenerTiposReservasActivas()
    {
    	Query q = em.createQuery("Select tr from TipoReserva tr where tr.estadoTr = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
