/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.CabinaVuelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface CabinaVueloFacadeLocal {

    void create(CabinaVuelo cabinaVuelo);

    void edit(CabinaVuelo cabinaVuelo);

    void remove(CabinaVuelo cabinaVuelo);

    CabinaVuelo find(Object id);

    List<CabinaVuelo> findAll();

    List<CabinaVuelo> findRange(int[] range);

    int count();
    
}
