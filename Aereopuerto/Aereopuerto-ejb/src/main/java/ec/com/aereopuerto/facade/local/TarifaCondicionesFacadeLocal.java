/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TarifaCondiciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TarifaCondicionesFacadeLocal {

    void create(TarifaCondiciones tarifaCondiciones);

    void edit(TarifaCondiciones tarifaCondiciones);

    void remove(TarifaCondiciones tarifaCondiciones);

    TarifaCondiciones find(Object id);

    List<TarifaCondiciones> findAll();

    List<TarifaCondiciones> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene la tarifa-condicion
     * @param codigoCondicion
     * @param codigoTarifa
     * @return
     */
	TarifaCondiciones obtenerTarifaCondiciones(Integer codigoCondicion, Integer codigoTarifa);
    
}
