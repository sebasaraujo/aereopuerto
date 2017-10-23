/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoReserva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoReservaFacadeLocal {

    void create(TipoReserva tipoReserva);

    void edit(TipoReserva tipoReserva);

    void remove(TipoReserva tipoReserva);

    TipoReserva find(Object id);

    List<TipoReserva> findAll();

    List<TipoReserva> findRange(int[] range);

    int count();
    
}
