/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Pasajero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PasajeroFacadeLocal {

    void create(Pasajero pasajero);

    void edit(Pasajero pasajero);

    void remove(Pasajero pasajero);

    Pasajero find(Object id);

    List<Pasajero> findAll();

    List<Pasajero> findRange(int[] range);

    int count();
    
}
