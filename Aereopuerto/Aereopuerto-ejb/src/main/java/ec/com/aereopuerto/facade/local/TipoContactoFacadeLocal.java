/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoContacto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoContactoFacadeLocal {

    void create(TipoContacto tipoContacto);

    void edit(TipoContacto tipoContacto);

    void remove(TipoContacto tipoContacto);

    TipoContacto find(Object id);

    List<TipoContacto> findAll();

    List<TipoContacto> findRange(int[] range);

    int count();
    
}
