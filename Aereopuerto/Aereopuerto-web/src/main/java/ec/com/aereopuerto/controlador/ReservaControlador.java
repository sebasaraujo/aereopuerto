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

import ec.com.aereopuerto.enumeradores.EstadoEnum;
import ec.com.aereopuerto.modelo.Aereopuerto;
import ec.com.aereopuerto.modelo.Condiciones;
import ec.com.aereopuerto.modelo.Impuesto;
import ec.com.aereopuerto.modelo.Pais;
import ec.com.aereopuerto.modelo.Pasajero;
import ec.com.aereopuerto.modelo.PasajeroCosto;
import ec.com.aereopuerto.modelo.Producto;
import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.modelo.TarifaCondiciones;
import ec.com.aereopuerto.modelo.TarifaProducto;
import ec.com.aereopuerto.modelo.TipoCabina;
import ec.com.aereopuerto.modelo.TipoIdentificacion;
import ec.com.aereopuerto.modelo.TipoPasajero;
import ec.com.aereopuerto.modelo.TipoReserva;
import ec.com.aereopuerto.service.local.AereopuertoService;
import ec.com.aereopuerto.service.local.CondicionesService;
import ec.com.aereopuerto.service.local.ImpuestoService;
import ec.com.aereopuerto.service.local.PaisService;
import ec.com.aereopuerto.service.local.ProductoService;
import ec.com.aereopuerto.service.local.ReservaService;
import ec.com.aereopuerto.service.local.TarifaCondicionesService;
import ec.com.aereopuerto.service.local.TarifaProductoService;
import ec.com.aereopuerto.service.local.TipoCabinaService;
import ec.com.aereopuerto.service.local.TipoIdentificacionService;
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
	private boolean tabPasajeros = false;
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
	
	//Variables seccion Pasajeros
	private List<Pasajero> listaPasajeros = new ArrayList<>();
	private List<TipoIdentificacion> tipoIdentificaciones = new ArrayList<>();
	private Integer codigoTipoIdentificacion;
	private List<Pais> paises = new ArrayList<>();
	private Integer codigoPais;
	
	//Variables seccion pago
	private boolean tabPago = false;
	private List<PasajeroCosto> pasajerosCosto = new ArrayList<>();
	
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
	@EJB
	private TipoIdentificacionService tipoIdentificacionService;
	@EJB
	private PaisService paisService;
	@EJB
	private ImpuestoService impuestoService;
	@EJB
	private ReservaService reservaService;

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
		tabPasajeros = false;
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
	
	public Double obtenerCostoProductoTarifaCabinaRegreso(Integer tarifa)
	{
		return tarifaProductoService.obtenerCostoProductoTarifaCabina(codigoProductoSeleccionadoResgreso, codigoTipoCabina, tarifa);
	}
	
	public void seleccionTarifaIda(Integer codigoTarifa)
	{
		reserva.setTipoTarifaIda(tipoTarifaService.obtenerXId(codigoTarifa));
		reserva.setProductoIdaRs(productoService.obtenerXId(codigoProductoSeleccionadoIda));
		reserva.setDesdeRs(reserva.getProductoIdaRs().getAereopuertoSalida());
		reserva.setHaciaRs(reserva.getProductoIdaRs().getAereopuertoLlegada());
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
	
	public void continuarTabSeccion()
	{
		listaPasajeros = new ArrayList<>();
		tabSeleccion = false;
		tabPasajeros = true;
		index = 2;
		tipoIdentificaciones = tipoIdentificacionService.obtenerTipoIdentificacion();
		paises = paisService.obtenerPaises();
		for(TipoPasajero tp : tipoPasajeros)
		{
			if(tp.getNumeroPasajeros() > 0)
			{
				for(int i = 0; i<tp.getNumeroPasajeros(); i++)
				{
					Pasajero pasajero = new Pasajero();
					pasajero.setTipoPasajero(tp);
					pasajero.setNumeroPasajero(i + 1);
					listaPasajeros.add(pasajero);
				}
				
			}
		}
	}
	
	public void continuarTabPasajeros()
	{
		for(Pasajero p : listaPasajeros)
		{
			System.out.println("nombre: "+p.getNombrePs());
			System.out.println("apellido: "+p.getApellidoPs());
			System.out.println("codigo tipo identificacion: "+p.getCodigoTipoIdentificacion());
			System.out.println("identificacion: "+p.getIdentifiacionPs());
			System.out.println("correo: "+p.getCorreoPs());
		}
		calcularCosto();
		tabPasajeros = false;
		tabPago = true;
		index = 3;
		
	}
	
	public void calcularCosto()
	{
		try {
			if(tabPasajeros)
			{
				pasajerosCosto = new ArrayList<>();
				List<Impuesto> impuestos = impuestoService.obtenerTodos();
				Double tarifaIda = obtenerCostoProductoTarifaCabina(reserva.getTipoTarifaIda().getCodigoTt());
				Double tarifaRegreso = 0.0;
				if(reserva.getTipoTarifaRegreso() != null)
					tarifaRegreso = obtenerCostoProductoTarifaCabinaRegreso(reserva.getTipoTarifaRegreso().getCodigoTt());
				Double tarifaBase = tarifaIda + tarifaRegreso;
				Double total = 0.0;
				for(Pasajero pasajero : listaPasajeros)
				{
					Double tarifa = (pasajero.getTipoPasajero().getPorcentajeTarifaTp() * tarifaBase)/100;
					Double impuesto = 0.0;
					for(Impuesto i : impuestos)
					{
						if(i.getTipoImpuesto().getCodigoTi().equals(Constantes.TIPO_IMPUESTO_FIJO))
						{
							impuesto += i.getValorIm();
						}
						else if(i.getTipoImpuesto().getCodigoTi().equals(Constantes.TIPO_IMPUESTO_PORCENTUAL))
						{
							impuesto += ((tarifa * i.getValorIm()) / 100);
						}
					}
					total += tarifa + impuesto;
					PasajeroCosto pasajeroCosto = new PasajeroCosto();
					pasajeroCosto.setImpuestoPc(impuesto);
					pasajeroCosto.setTarifaPc(tarifa);
					pasajeroCosto.setPasajero(pasajero);
					pasajeroCosto.setReserva(reserva);
					pasajerosCosto.add(pasajeroCosto);
				}
				reserva.setCostoTotalRs(total);
			}
		} catch (Exception e) {
		}
		
		
	}
	
	public void finalizarReserva()
	{
		try {
			System.out.println("hacia rs: "+reserva.getHaciaRs());
			reserva.setEstadoRs(EstadoEnum.ACTIVO.getValor());
			reserva.setFechaActRs(new Date());
			reserva.setNumeroRs("RES001");
			reserva.setUsuarioActRs(1);
			reservaService.crear(reserva);
			agregarMensajeInformacion("Reserva / Compra realizada satisfactoriamente", "Reserva / Compra realizada satisfactoriamente");
		} catch (Exception e) {
			e.printStackTrace();
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


	public boolean isTabPasajeros() {
		return tabPasajeros;
	}


	public void setTabPasajeros(boolean tabPasajeros) {
		this.tabPasajeros = tabPasajeros;
	}


	public List<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}


	public void setListaPasajeros(List<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}


	public List<TipoIdentificacion> getTipoIdentificaciones() {
		return tipoIdentificaciones;
	}


	public void setTipoIdentificaciones(List<TipoIdentificacion> tipoIdentificaciones) {
		this.tipoIdentificaciones = tipoIdentificaciones;
	}


	public Integer getCodigoTipoIdentificacion() {
		return codigoTipoIdentificacion;
	}


	public void setCodigoTipoIdentificacion(Integer codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}


	public List<Pais> getPaises() {
		return paises;
	}


	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}


	public Integer getCodigoPais() {
		return codigoPais;
	}


	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}


	public boolean isTabPago() {
		return tabPago;
	}


	public void setTabPago(boolean tabPago) {
		this.tabPago = tabPago;
	}


	public List<PasajeroCosto> getPasajerosCosto() {
		return pasajerosCosto;
	}


	public void setPasajerosCosto(List<PasajeroCosto> pasajerosCosto) {
		this.pasajerosCosto = pasajerosCosto;
	}

}
