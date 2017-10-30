/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.aereopuerto.facade.local.TipoTarifaFacadeLocal;
import ec.com.aereopuerto.modelo.TipoTarifa;

/**
 *
 * @author sebastian
 */
@Stateless
public class TipoTarifaFacade extends AbstractFacade<TipoTarifa> implements TipoTarifaFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTarifaFacade() {
        super(TipoTarifa.class);
    }
    
}
