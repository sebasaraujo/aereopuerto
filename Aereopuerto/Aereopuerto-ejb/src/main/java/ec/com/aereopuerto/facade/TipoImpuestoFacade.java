/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.TipoImpuestoFacadeLocal;
import ec.com.aereopuerto.modelo.TipoImpuesto;

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
public class TipoImpuestoFacade extends AbstractFacade<TipoImpuesto> implements TipoImpuestoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoImpuestoFacade() {
        super(TipoImpuesto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoImpuesto> obtenerTodosTiposImpuestos()
    {
    	Query q = em.createQuery("Select ti from TipoImpuesto ti where ti.estadoTi = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
}
