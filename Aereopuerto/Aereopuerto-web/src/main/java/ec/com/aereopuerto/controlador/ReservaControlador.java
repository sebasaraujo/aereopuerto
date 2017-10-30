package ec.com.aereopuerto.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import ec.com.aereopuerto.modelo.Aereopuerto;
import ec.com.aereopuerto.modelo.Producto;
import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.modelo.TipoReserva;
import ec.com.aereopuerto.service.local.AereopuertoService;
import ec.com.aereopuerto.service.local.ProductoService;
import ec.com.aereopuerto.service.local.TipoReservaService;

@Named(value = "reservaControlador")
@ViewScoped
public class ReservaControlador extends BaseControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2959868846447815506L;

	private Reserva reserva;
	private List<TipoReserva> tipoReservas = new ArrayList<>();
	private Integer codigoTipoReserva;
	private boolean skip;
	private Aereopuerto aereopuertoDesde;
	private Date fechaSalida;
	private Date fechaActual;
	private Aereopuerto aereopuertoHacia;
	private Date fechaRetorno;

	@EJB
	private TipoReservaService tipoReservaService;
	@EJB
	private AereopuertoService aereopuertoService;
	@EJB
	private ProductoService productoService;

	@PostConstruct
	private void init() {
		reserva = new Reserva();
		tipoReservas = tipoReservaService.obtenerTiposReservasActivas();
		fechaActual = new Date();
		fechaSalida = new Date();
		codigoTipoReserva = 1;
	}


	public List<Aereopuerto> completeAereopuerto(String query) {
		List<Aereopuerto> allAereopuertos = aereopuertoService.obtenerAereopuertosActivos();
		List<Aereopuerto> filteredAereopuertos = new ArrayList<Aereopuerto>();

		for (int i = 0; i < allAereopuertos.size(); i++) {
			Aereopuerto aereopuerto = allAereopuertos.get(i);
			if (aereopuerto.getNemonicoAe().toLowerCase().startsWith(query)) {
				filteredAereopuertos.add(aereopuerto);
			}
		}

		return filteredAereopuertos;
	}
	
	public List<Aereopuerto> completeAereopuertoHacia(String query) {
		List<Aereopuerto> allAereopuertos = new ArrayList<Aereopuerto>();
		if(aereopuertoDesde != null && aereopuertoDesde.getCodigoAe() != null)
		{
			allAereopuertos = aereopuertoService.obtenerAereopuertosSinDestino(aereopuertoDesde.getCodigoAe());
		}
		else
		{
			allAereopuertos = aereopuertoService.obtenerAereopuertosActivos();
		}
		List<Aereopuerto> filteredAereopuertos = new ArrayList<Aereopuerto>();

		for (int i = 0; i < allAereopuertos.size(); i++) {
			Aereopuerto aereopuerto = allAereopuertos.get(i);
			if (aereopuerto.getNemonicoAe().toLowerCase().startsWith(query)) {
				filteredAereopuertos.add(aereopuerto);
			}
		}

		return filteredAereopuertos;
	}

	public void tipoReservaChange(ValueChangeEvent changeEvent)
	{
		if(changeEvent.getNewValue() != null)
		{
			codigoTipoReserva = Integer.parseInt(changeEvent.getNewValue().toString());
		}
	}
	
	public void aereopuertoDesdeChange(SelectEvent changeEvent)
	{
		if(changeEvent.getObject() != null)
		{
			aereopuertoDesde = (Aereopuerto)changeEvent.getObject();
		}
	}
	
	public void aereopuertoHaciaChange(SelectEvent changeEvent)
	{
		if(changeEvent.getObject() != null)
		{
			aereopuertoHacia = (Aereopuerto)changeEvent.getObject();
		}
	}
	
	public void onDateSelect(SelectEvent event) {
		fechaSalida = (Date) event.getObject();
		fechaRetorno = null;
	}
	
	public void onDateSelectFechaRetorno(SelectEvent event) {
		fechaRetorno = (Date) event.getObject();
	}
	
	public void buscar ()
	{
		List<Producto> listaProductos = productoService.obtenerProductosBusqueda(aereopuertoDesde.getCodigoAe(), aereopuertoHacia.getCodigoAe(), fechaSalida);
		for(Producto p : listaProductos)
		{
			System.out.println("producto: "+p.getCodigoPo());
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

	public Aereopuerto getAereopuertoDesde() {
		return aereopuertoDesde;
	}

	public void setAereopuertoDesde(Aereopuerto aereopuertoDesde) {
		this.aereopuertoDesde = aereopuertoDesde;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Aereopuerto getAereopuertoHacia() {
		return aereopuertoHacia;
	}

	public void setAereopuertoHacia(Aereopuerto aereopuertoHacia) {
		this.aereopuertoHacia = aereopuertoHacia;
	}

	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

}
