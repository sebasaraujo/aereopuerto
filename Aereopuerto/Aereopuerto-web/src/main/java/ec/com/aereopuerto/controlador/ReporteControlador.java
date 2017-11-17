package ec.com.aereopuerto.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import ec.com.aereopuerto.modelo.Pasajero;
import ec.com.aereopuerto.modelo.PasajeroCosto;
import ec.com.aereopuerto.modelo.ProductoVuelo;
import ec.com.aereopuerto.modelo.Reserva;
import ec.com.aereopuerto.modelo.Vuelo;
import ec.com.aereopuerto.service.local.ProductoVueloService;
import ec.com.aereopuerto.servlet.ReportServlet;

@Named(value = "reporteControlador")
@ViewScoped
public class ReporteControlador extends BaseControlador implements Serializable{

	private static final long serialVersionUID = 4295597100949624998L;
	
	@EJB
	private ProductoVueloService productoVueloService;

	@PostConstruct
	public void init()
	{
		
	}
	
	public void generarReporteReserva(Reserva reserva, List<Pasajero> pasajeros, List<PasajeroCosto> pasajerosCosto)
	{
		try {
//			JasperReport jasperReport = JasperCompileManager
//		               .compileReport("C:/reporte/reserva.jrxml");
//		 
		       // Parameters for report
		       Map<String, Object> parameters = new HashMap<String, Object>();
		 
		       System.out.println("producto :"+reserva.getProductoIdaRs());
		       List<ProductoVuelo> productoVueloIda = productoVueloService.obtenerProductoVueloXProducto(reserva.getProductoIdaRs().getCodigoPo());
		       List<ProductoVuelo> productoVueloRegreso = new ArrayList<>();
		       if(reserva.getProductoRetornoRs() != null && reserva.getProductoRetornoRs().getCodigoPo() != null)
		       {
		    	   productoVueloRegreso = productoVueloService.obtenerProductoVueloXProducto(reserva.getProductoRetornoRs().getCodigoPo());
		       }
		       System.out.println("productoVueloRegreso: "+productoVueloRegreso);
		       parameters.put("CodigoReserva", reserva.getNumeroRs());
		       parameters.put("reserva", reserva);
		       parameters.put("pasajeros", pasajeros);
		       parameters.put("productoIda", productoVueloIda);
		       parameters.put("productoRegreso", productoVueloRegreso);
		       parameters.put("pasajerosCosto",pasajerosCosto);
		       parameters.put("totalCobrado", reserva.getCostoTotalRs());
		       
		       Map<String,Object> subReportes = new HashMap<String, Object>();
		       subReportes.put("vuelos","vuelos");
		       subReportes.put("vuelos_regreso","vuelos_regreso");
		       subReportes.put("tarifa","tarifa");
		       // DataSource
		       // This is simple example, no database.
		       // then using empty datasource.
//		       JRDataSource dataSource = new JREmptyDataSource();
//		 
//		       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
//		               parameters, dataSource);
//		 
//		    
//		       // Make sure the output directory exists.
//		       File outDir = new File("C:/jasperoutput");
//		       outDir.mkdirs();
//		 
		    // Export to PDF.
//		       JasperExportManager.exportReportToPdfFile(jasperPrint,
//		               "C:/jasperoutput/reserva.pdf");
//		       
		       
		       HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				request.getSession().setAttribute(ReportServlet.OBJETO_REPORTE, parameters);
				request.getSession().setAttribute(ReportServlet.OBJETO_SUB_REPORTE, subReportes);
		       
		        
		       System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
