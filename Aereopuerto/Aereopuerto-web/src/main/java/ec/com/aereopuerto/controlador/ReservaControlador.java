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
import ec.com.aereopuerto.modelo.Condiciones;
import ec.com.aereopuerto.modelo.Producto;
import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.modelo.TarifaCondiciones;
import ec.com.aereopuerto.modelo.TarifaProducto;
import ec.com.aereopuerto.modelo.TipoCabina;
import ec.com.aereopuerto.modelo.TipoPasajero;
import ec.com.aereopuerto.modelo.TipoReserva;
import ec.com.aereopuerto.service.local.AereopuertoService;
import ec.com.aereopuerto.service.local.CondicionesService;
import ec.com.aereopuerto.service.local.ProductoService;
import ec.com.aereopuerto.service.local.TarifaCondicionesService;
import ec.com.aereopuerto.service.local.TarifaProductoService;
import ec.com.aereopuerto.service.local.TipoCabinaService;
import ec.com.aereopuerto.service.local.TipoPasajeroService;
import ec.com.aereopuerto.service.local.TipoReservaService;
import ec.com.aereopuerto.service.local.TipoTarifaService;
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
	private Integer codigoTipoReserva = 1;
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
	private List<TipoCabina> tipoCabinas = new ArrayList<>();
	private Integer codigoTipoCabina;
	private List<TipoPasajero> tipoPasajeros = new ArrayList<>();
	private boolean seleccionTarifaVueloIda = false;
	private List<TarifaProducto> listaTarifaProductoIda = new ArrayList<>();
	private List<Condiciones> listaCondiciones = new ArrayList<>();
	private Integer codigoProductoSeleccionadoIda;
	private boolean tablaCondicionesTarifaIda = false;
	private boolean panelResumenVueloIda = false;
	private boolean tablaCondicionesTarifaRegreso = false;
	private Integer codigoProductoSeleccionadoResgreso;
	private boolean seleccionTarifaVueloRegreso = false;
	private List<TarifaProducto> listaTarifaProductoRegreso = new ArrayList<>();
	private List<Condiciones> listaCondicionesRegreso = new ArrayList<>();
	private boolean panelResumenVueloRegreso = false;
	
	@EJB
	private TipoReservaService tipoReservaService;
	@EJB
	private AereopuertoService aereopuertoService;
	@EJB
	private ProductoService productoService;
	@EJB
	private TipoCabinaService tipoCabinaService;
	@EJB
	private TipoPasajeroService tipoPasajeroService;
	@EJB
	private TarifaProductoService tarifaProductoService;
	@EJB
	private CondicionesService condicionesService;
	@EJB
	private TarifaCondicionesService tarifaCondicionesService;
	@EJB
	private TipoTarifaService tipoTarifaService;

	@PostConstruct
	private void init() {
		reserva = new Reserva();
		tipoReservas = tipoReservaService.obtenerTiposReservasActivas();
		tipoCabinas = tipoCabinaService.obtenerTipoCabinasActivo();
		for(TipoReserva tr : tipoReservas)
		{
			SelectItem tipoReserva = new SelectItem(tr.getCodigoTr(), tr.getNombreTr());
			tipoReservaItem.add(tipoReserva);
			setCodigoTipoReserva(tr.getCodigoTr());
		}
		fechaActual = new Date();
		fechaSalida = new Date();
		tabReserva = true;
		index = 0;
		tablaCondicionesTarifaIda = false;
		tablaCondicionesTarifaRegreso = false;
		panelResumenVueloIda = false;
		panelResumenVueloRegreso = false;
		tipoPasajeros = tipoPasajeroService.obtenerTipoPasajeros();
		for(TipoPasajero tp : tipoPasajeros)
		{
			if(tp.getCodigoTp().equals(Constantes.TIPO_PASAJERO_ADULTO))
			{
				tp.setNumeroPasajeros(1);
			}
		}
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
		System.out.println("tipo cabina: "+codigoTipoCabina);
		listaProductosIda = productoService.obtenerProductosBusqueda(aereopuertoDesde.getCodigoAe(), aereopuertoHacia.getCodigoAe(), fechaSalida, codigoTipoCabina);
		listaProductosRegreso = productoService.obtenerProductosBusqueda(aereopuertoHacia.getCodigoAe(), aereopuertoDesde.getCodigoAe(), fechaRetorno, codigoTipoCabina);
		tabSeleccion = true;
		tabReserva = false;
		index = 1;
		seleccionTarifaVueloIda = false;
		tablaCondicionesTarifaIda = false;
		tablaCondicionesTarifaRegreso = false;
		panelResumenVueloIda = false;
		panelResumenVueloRegreso = false;
		reserva.setDesdeRs(aereopuertoDesde);
		reserva.setFechaSalida(fechaSalida);
		reserva.setFechaRetorno(fechaRetorno);
		reserva.setTipoReserva(tipoReservaService.obtenerXId(codigoTipoReserva));
		reserva.setTipoCabina(tipoCabinaService.obtenerXId(codigoTipoCabina));
	}
	
	
	public void seleccionVueloIda(Integer codigoProducto)
	{
		codigoProductoSeleccionadoIda = codigoProducto;
		seleccionTarifaVueloIda = true;
		tablaCondicionesTarifaIda = true;
		listaCondiciones = condicionesService.obtenerCondiciones();
		listaTarifaProductoIda = tarifaProductoService.obtenerTarifaProductoXProductoCabina(codigoProducto, codigoTipoCabina);
	}
	
	public Double obtenerCostoMinimo(Integer codigoProducto)
	{
		return tarifaProductoService.obtenerCostoMinimoProducto(codigoProducto, codigoTipoCabina);
	}
	
	public String obtenerDescripcionTarifaCondicion(Integer codigoTarifa, Integer codigoCondicion)
	{
		TarifaCondiciones tarifaCondicion = tarifaCondicionesService.obtenerTarifaCondiciones(codigoCondicion, codigoTarifa);
		if(tarifaCondicion!= null)
		{
			return tarifaCondicion.getDescripcion();
		}
		else
		{
			return "";
		}
	}
	
	public void cancelarSeleccionTarifa()
	{
		System.out.println("cancelar");
		seleccionTarifaVueloIda = false;
		tablaCondicionesTarifaIda = false;
	}
	
	public Double obtenerCostoProductoTarifaCabina(Integer tarifa)
	{
		return tarifaProductoService.obtenerCostoProductoTarifaCabina(codigoProductoSeleccionadoIda, codigoTipoCabina, tarifa);
	}
	
	public void seleccionTarifaIda(Integer codigoTarifa)
	{
		reserva.setTipoTarifaIda(tipoTarifaService.obtenerXId(codigoTarifa));
		reserva.setProductoIdaRs(productoService.obtenerXId(codigoProductoSeleccionadoIda));
		tablaCondicionesTarifaIda = false;
		panelResumenVueloIda = true;
		if(codigoTipoReserva.equals(Constantes.TIPO_RESERVA_IDA_VUELTA))
		{
			mostrarVuelosRegreso = true;
		}
	}
	
	public void seleccionVueloRegreo(Integer codigoProducto)
	{
		codigoProductoSeleccionadoResgreso = codigoProducto;
		seleccionTarifaVueloRegreso = true;
		tablaCondicionesTarifaRegreso = true;
		listaCondicionesRegreso = condicionesService.obtenerCondiciones();
		listaTarifaProductoRegreso = tarifaProductoService.obtenerTarifaProductoXProductoCabina(codigoProducto, codigoTipoCabina);
	}
	
	public void cancelarSeleccionTarifaRegreso()
	{
		seleccionTarifaVueloRegreso = false;
		tablaCondicionesTarifaRegreso = false;
	}
	
	public void seleccionTarifaRegreso(Integer codigoTarifa)
	{
		reserva.setTipoTarifaRegreso(tipoTarifaService.obtenerXId(codigoTarifa));
		reserva.setProductoRetornoRs(productoService.obtenerXId(codigoProductoSeleccionadoResgreso));
		tablaCondicionesTarifaRegreso = false;
		panelResumenVueloRegreso = true;
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


	public List<TipoCabina> getTipoCabinas() {
		return tipoCabinas;
	}


	public void setTipoCabinas(List<TipoCabina> tipoCabinas) {
		this.tipoCabinas = tipoCabinas;
	}


	public Integer getCodigoTipoCabina() {
		return codigoTipoCabina;
	}


	public void setCodigoTipoCabina(Integer codigoTipoCabina) {
		this.codigoTipoCabina = codigoTipoCabina;
	}


	public List<TipoPasajero> getTipoPasajeros() {
		return tipoPasajeros;
	}


	public void setTipoPasajeros(List<TipoPasajero> tipoPasajeros) {
		this.tipoPasajeros = tipoPasajeros;
	}


	public boolean isSeleccionTarifaVueloIda() {
		return seleccionTarifaVueloIda;
	}


	public void setSeleccionTarifaVueloIda(boolean seleccionTarifaVueloIda) {
		this.seleccionTarifaVueloIda = seleccionTarifaVueloIda;
	}


	public List<TarifaProducto> getListaTarifaProductoIda() {
		return listaTarifaProductoIda;
	}


	public void setListaTarifaProductoIda(List<TarifaProducto> listaTarifaProductoIda) {
		this.listaTarifaProductoIda = listaTarifaProductoIda;
	}


	public List<Condiciones> getListaCondiciones() {
		return listaCondiciones;
	}


	public void setListaCondiciones(List<Condiciones> listaCondiciones) {
		this.listaCondiciones = listaCondiciones;
	}


	public Integer getCodigoProductoSeleccionadoIda() {
		return codigoProductoSeleccionadoIda;
	}


	public void setCodigoProductoSeleccionadoIda(Integer codigoProductoSeleccionadoIda) {
		this.codigoProductoSeleccionadoIda = codigoProductoSeleccionadoIda;
	}


	public boolean isTablaCondicionesTarifaIda() {
		return tablaCondicionesTarifaIda;
	}


	public void setTablaCondicionesTarifaIda(boolean tablaCondicionesTarifaIda) {
		this.tablaCondicionesTarifaIda = tablaCondicionesTarifaIda;
	}


	public boolean isPanelResumenVueloIda() {
		return panelResumenVueloIda;
	}


	public void setPanelResumenVueloIda(boolean panelResumenVueloIda) {
		this.panelResumenVueloIda = panelResumenVueloIda;
	}


	public boolean isTablaCondicionesTarifaRegreso() {
		return tablaCondicionesTarifaRegreso;
	}


	public void setTablaCondicionesTarifaRegreso(boolean tablaCondicionesTarifaRegreso) {
		this.tablaCondicionesTarifaRegreso = tablaCondicionesTarifaRegreso;
	}


	public boolean isSeleccionTarifaVueloRegreso() {
		return seleccionTarifaVueloRegreso;
	}


	public void setSeleccionTarifaVueloRegreso(boolean seleccionTarifaVueloRegreso) {
		this.seleccionTarifaVueloRegreso = seleccionTarifaVueloRegreso;
	}


	public List<TarifaProducto> getListaTarifaProductoRegreso() {
		return listaTarifaProductoRegreso;
	}


	public void setListaTarifaProductoRegreso(List<TarifaProducto> listaTarifaProductoRegreso) {
		this.listaTarifaProductoRegreso = listaTarifaProductoRegreso;
	}


	public List<Condiciones> getListaCondicionesRegreso() {
		return listaCondicionesRegreso;
	}


	public void setListaCondicionesRegreso(List<Condiciones> listaCondicionesRegreso) {
		this.listaCondicionesRegreso = listaCondicionesRegreso;
	}


	public boolean isPanelResumenVueloRegreso() {
		return panelResumenVueloRegreso;
	}


	public void setPanelResumenVueloRegreso(boolean panelResumenVueloRegreso) {
		this.panelResumenVueloRegreso = panelResumenVueloRegreso;
	}

}
