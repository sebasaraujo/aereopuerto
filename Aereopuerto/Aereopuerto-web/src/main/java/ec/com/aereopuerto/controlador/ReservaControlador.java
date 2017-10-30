package ec.com.aereopuerto.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
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
import ec.com.aereopuerto.util.Constantes;

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
	private List<SelectItem> tipoReservaItem = new ArrayList<>();
	private boolean tabReserva = false;
	private boolean tabSeleccion = false;
	private Integer index = 0;
	private List<Producto> listaProductosIda = new ArrayList<>();
	private List<Producto> listaProductosRegreso = new ArrayList<>();
	private boolean mostrarVuelosRegreso = false;

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
		for(TipoReserva tr : tipoReservas)
		{
			SelectItem tipoReserva = new SelectItem(tr.getCodigoTr(), tr.getNombreTr());
			tipoReservaItem.add(tipoReserva);
		}
		fechaActual = new Date();
		fechaSalida = new Date();
		codigoTipoReserva = 1;
		tabReserva = true;
		index = 0;
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
		listaProductosIda = productoService.obtenerProductosBusqueda(aereopuertoDesde.getCodigoAe(), aereopuertoHacia.getCodigoAe(), fechaSalida);
		listaProductosRegreso = productoService.obtenerProductosBusqueda(aereopuertoHacia.getCodigoAe(), aereopuertoDesde.getCodigoAe(), fechaRetorno);
		tabSeleccion = true;
		tabReserva = false;
		index = 1;
	}
	
	public void seleccionVueloIda(Integer codigoProducto)
	{
		System.out.println("codigo Tipo Reserva: "+codigoTipoReserva);
		System.out.println("Producto seleccionado: "+codigoProducto);
		if(codigoTipoReserva.equals(Constantes.TIPO_RESERVA_IDA_VUELTA))
		{
			mostrarVuelosRegreso = true;
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


	public List<SelectItem> getTipoReservaItem() {
		return tipoReservaItem;
	}


	public void setTipoReservaItem(List<SelectItem> tipoReservaItem) {
		this.tipoReservaItem = tipoReservaItem;
	}


	public boolean isTabReserva() {
		return tabReserva;
	}


	public void setTabReserva(boolean tabReserva) {
		this.tabReserva = tabReserva;
	}


	public boolean isTabSeleccion() {
		return tabSeleccion;
	}


	public void setTabSeleccion(boolean tabSeleccion) {
		this.tabSeleccion = tabSeleccion;
	}


	public Integer getIndex() {
		return index;
	}


	public void setIndex(Integer index) {
		this.index = index;
	}


	public List<Producto> getListaProductosIda() {
		return listaProductosIda;
	}


	public void setListaProductosIda(List<Producto> listaProductosIda) {
		this.listaProductosIda = listaProductosIda;
	}


	public List<Producto> getListaProductosRegreso() {
		return listaProductosRegreso;
	}


	public void setListaProductosRegreso(List<Producto> listaProductosRegreso) {
		this.listaProductosRegreso = listaProductosRegreso;
	}


	public boolean isMostrarVuelosRegreso() {
		return mostrarVuelosRegreso;
	}


	public void setMostrarVuelosRegreso(boolean mostrarVuelosRegreso) {
		this.mostrarVuelosRegreso = mostrarVuelosRegreso;
	}

}
