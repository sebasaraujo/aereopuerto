/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoVuelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoVueloFacadeLocal {

    void create(TipoVuelo tipoVuelo);

    void edit(TipoVuelo tipoVuelo);

    void remove(TipoVuelo tipoVuelo);

    TipoVuelo find(Object id);

    List<TipoVuelo> findAll();

    List<TipoVuelo> findRange(int[] range);

    int count();
    
}
