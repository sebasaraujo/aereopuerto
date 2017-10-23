/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.ContactoPasajero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ContactoPasajeroFacadeLocal {

    void create(ContactoPasajero contactoPasajero);

    void edit(ContactoPasajero contactoPasajero);

    void remove(ContactoPasajero contactoPasajero);

    ContactoPasajero find(Object id);

    List<ContactoPasajero> findAll();

    List<ContactoPasajero> findRange(int[] range);

    int count();
    
}
