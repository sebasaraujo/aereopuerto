/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.CabinaVueloFacadeLocal;
import ec.com.aereopuerto.modelo.CabinaVuelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebastian
 */
@Stateless
public class CabinaVueloFacade extends AbstractFacade<CabinaVuelo> implements CabinaVueloFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CabinaVueloFacade() {
        super(CabinaVuelo.class);
    }
    
}
