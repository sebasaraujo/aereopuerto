/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoPasajero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoPasajeroFacadeLocal {

    void create(TipoPasajero tipoPasajero);

    void edit(TipoPasajero tipoPasajero);

    void remove(TipoPasajero tipoPasajero);

    TipoPasajero find(Object id);

    List<TipoPasajero> findAll();

    List<TipoPasajero> findRange(int[] range);

    int count();
    
}
