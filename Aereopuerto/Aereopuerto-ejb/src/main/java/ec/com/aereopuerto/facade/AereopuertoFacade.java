/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.facade.local.AereopuertoFacadeLocal;
import ec.com.aereopuerto.modelo.Aereopuerto;

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
public class AereopuertoFacade extends AbstractFacade<Aereopuerto> implements AereopuertoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AereopuertoFacade() {
        super(Aereopuerto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Aereopuerto> obtenerAereopuertosActivos()
    {
    	Query q = em.createQuery("Select a from Aereopuerto a where a.estadoAe = :estado");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Aereopuerto> obtenerAereopuertosSinDestino(Integer destino)
    {
    	Query q = em.createQuery("Select a from Aereopuerto a where a.estadoAe = :estado and a.codigoAe != :destino");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("destino", destino);
    	return q.getResultList();
    }
    
}
