package ec.com.aereopuerto.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;

import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.modelo.TipoReserva;
import ec.com.aereopuerto.service.local.TipoReservaService;

@Named(value="reservaControlador")
@ViewScoped
public class ReservaControlador extends BaseControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959868846447815506L;

	private Reserva reserva;
	private List<TipoReserva> tipoReservas = new ArrayList<>();
	private Integer codigoTipoReserva;
	private boolean skip;
	
	@EJB
	private TipoReservaService tipoReservaService;
	
	@PostConstruct
	private void init()
	{
		reserva = new Reserva();
		tipoReservas = tipoReservaService.obtenerTiposReservasActivas();
		System.out.println("tipo de reservas: "+tipoReservas.size());
	}

	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<TipoReserva> getTipoReservas() {
		return tipoReservas;
	}

	public void setTipoReservas(List<TipoReserva> tipoReservas) {
		this.tipoReservas = tipoReservas;
	}

	public Integer getCodigoTipoReserva() {
		return codigoTipoReserva;
	}

	public void setCodigoTipoReserva(Integer codigoTipoReserva) {
		this.codigoTipoReserva = codigoTipoReserva;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	
}
