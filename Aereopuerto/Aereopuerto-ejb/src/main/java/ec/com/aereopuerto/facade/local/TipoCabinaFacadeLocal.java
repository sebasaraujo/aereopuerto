/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoCabina;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebastian
 */
@Local
public interface TipoCabinaFacadeLocal {

    void create(TipoCabina tipoCabina);

    void edit(TipoCabina tipoCabina);

    void remove(TipoCabina tipoCabina);

    TipoCabina find(Object id);

    List<TipoCabina> findAll();

    List<TipoCabina> findRange(int[] range);

    int count();
    
}
