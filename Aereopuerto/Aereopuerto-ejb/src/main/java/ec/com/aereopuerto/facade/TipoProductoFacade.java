/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade;

import ec.com.aereopuerto.facade.local.TipoProductoFacadeLocal;
import ec.com.aereopuerto.modelo.TipoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class TipoProductoFacade extends AbstractFacade<TipoProducto> implements TipoProductoFacadeLocal {

    @PersistenceContext(unitName = "aereopuertoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProductoFacade() {
        super(TipoProducto.class);
    }
    
}
