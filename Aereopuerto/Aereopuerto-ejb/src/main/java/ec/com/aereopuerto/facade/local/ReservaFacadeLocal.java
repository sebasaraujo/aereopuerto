/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.aereopuerto.facade.local;

import ec.com.aereopuerto.modelo.Reserva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ReservaFacadeLocal {

    void create(Reserva reserva);

    void edit(Reserva reserva);

    void remove(Reserva reserva);

    Reserva find(Object id);

    List<Reserva> findAll();

    List<Reserva> findRange(int[] range);

    int count();

    /**
     * Metodo que valida si el numero de reserva ya existe
     * @param numero
     * @return
     */
	boolean validarNumeroReserva(String numero);
    
}
