/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.PasajeroReserva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PasajeroReservaFacadeLocal {

    void create(PasajeroReserva pasajeroReserva);

    void edit(PasajeroReserva pasajeroReserva);

    void remove(PasajeroReserva pasajeroReserva);

    PasajeroReserva find(Object id);

    List<PasajeroReserva> findAll();

    List<PasajeroReserva> findRange(int[] range);

    int count();
    
}
