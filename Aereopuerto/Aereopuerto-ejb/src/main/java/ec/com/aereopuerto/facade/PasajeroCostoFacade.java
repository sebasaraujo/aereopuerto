/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.PasajeroCostoFacadeLocal;
import ec.com.aereopuerto.modelo.PasajeroCosto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class PasajeroCostoFacade extends AbstractFacade<PasajeroCosto> implements PasajeroCostoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasajeroCostoFacade() {
        super(PasajeroCosto.class);
    }
    
}
