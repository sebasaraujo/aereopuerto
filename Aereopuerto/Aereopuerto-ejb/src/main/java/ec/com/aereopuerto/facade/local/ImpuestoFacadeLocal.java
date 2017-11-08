/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.aereopuerto.modelo.Impuesto;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ImpuestoFacadeLocal {

    void create(Impuesto impuesto);

    void edit(Impuesto impuesto);

    void remove(Impuesto impuesto);

    Impuesto find(Object id);

    List<Impuesto> findAll();

    List<Impuesto> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene todos los impuestos activos
     * @return
     */
	List<Impuesto> obtenerTodos();
    
}
