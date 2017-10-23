/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.ContactoPasajeroFacadeLocal;
import ec.com.aereopuerto.modelo.ContactoPasajero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class ContactoPasajeroFacade extends AbstractFacade<ContactoPasajero> implements ContactoPasajeroFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoPasajeroFacade() {
        super(ContactoPasajero.class);
    }
    
}
