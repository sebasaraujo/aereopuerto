/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.ReservaFacadeLocal;
import ec.com.aereopuerto.modelo.Reserva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }
    
    @Override
    public boolean validarNumeroReserva(String numero)
    {
    	boolean resultado = false;
    	Query q = em.createQuery("Select r from Reserva r where r.estadoRs = :estado and r.numeroRs = :numero");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("numero", numero);
    	if(q.getResultList().isEmpty())
    	{
    		resultado = true;
    	}
    	return resultado;
    }
    
}
