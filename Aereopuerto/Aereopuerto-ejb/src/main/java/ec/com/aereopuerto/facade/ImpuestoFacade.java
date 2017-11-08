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
import ec.com.aereopuerto.facade.local.ImpuestoFacadeLocal;
import ec.com.aereopuerto.modelo.Impuesto;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class ImpuestoFacade extends AbstractFacade<Impuesto> implements ImpuestoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpuestoFacade() {
        super(Impuesto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Impuesto> obtenerTodos()
    {
    	Query q = em.createQuery("Select i from Impuesto i left join fetch i.tipoImpuesto ti where i.estadoIm = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
