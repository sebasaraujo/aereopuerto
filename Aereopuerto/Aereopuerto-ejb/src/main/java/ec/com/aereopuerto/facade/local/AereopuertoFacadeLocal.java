/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Aereopuerto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface AereopuertoFacadeLocal {

    void create(Aereopuerto aereopuerto);

    void edit(Aereopuerto aereopuerto);

    void remove(Aereopuerto aereopuerto);

    Aereopuerto find(Object id);

    List<Aereopuerto> findAll();

    List<Aereopuerto> findRange(int[] range);

    int count();
    
}
