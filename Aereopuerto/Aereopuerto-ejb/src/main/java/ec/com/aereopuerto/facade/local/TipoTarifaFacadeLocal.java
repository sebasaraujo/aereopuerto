/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoTarifa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TipoTarifaFacadeLocal {

    void create(TipoTarifa tipoTarifa);

    void edit(TipoTarifa tipoTarifa);

    void remove(TipoTarifa tipoTarifa);

    TipoTarifa find(Object id);

    List<TipoTarifa> findAll();

    List<TipoTarifa> findRange(int[] range);

    int count();
    
}
