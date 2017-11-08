/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.TipoImpuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoImpuestoFacadeLocal {

    void create(TipoImpuesto tipoImpuesto);

    void edit(TipoImpuesto tipoImpuesto);

    void remove(TipoImpuesto tipoImpuesto);

    TipoImpuesto find(Object id);

    List<TipoImpuesto> findAll();

    List<TipoImpuesto> findRange(int[] range);

    int count();
    
    /**
     * Metodo que obtiene todos los tipos de impuestos activos
     * @return
     */
	List<TipoImpuesto> obtenerTodosTiposImpuestos();
    
}
