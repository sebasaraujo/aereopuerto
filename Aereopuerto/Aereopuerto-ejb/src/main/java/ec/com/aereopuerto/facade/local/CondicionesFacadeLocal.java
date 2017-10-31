/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Condiciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface CondicionesFacadeLocal {

    void create(Condiciones condiciones);

    void edit(Condiciones condiciones);

    void remove(Condiciones condiciones);

    Condiciones find(Object id);

    List<Condiciones> findAll();

    List<Condiciones> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene las condiciones activas
     * @return
     */
	List<Condiciones> obtenerCondiciones();
    
}
