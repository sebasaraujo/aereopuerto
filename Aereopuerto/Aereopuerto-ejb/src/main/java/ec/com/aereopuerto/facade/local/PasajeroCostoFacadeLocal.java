/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.PasajeroCosto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PasajeroCostoFacadeLocal {

    void create(PasajeroCosto pasajeroCosto);

    void edit(PasajeroCosto pasajeroCosto);

    void remove(PasajeroCosto pasajeroCosto);

    PasajeroCosto find(Object id);

    List<PasajeroCosto> findAll();

    List<PasajeroCosto> findRange(int[] range);

    int count();
    
}
