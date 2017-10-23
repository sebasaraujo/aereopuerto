/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Aereolinea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface AereolineaFacadeLocal {

    void create(Aereolinea aereolinea);

    void edit(Aereolinea aereolinea);

    void remove(Aereolinea aereolinea);

    Aereolinea find(Object id);

    List<Aereolinea> findAll();

    List<Aereolinea> findRange(int[] range);

    int count();
    
}
