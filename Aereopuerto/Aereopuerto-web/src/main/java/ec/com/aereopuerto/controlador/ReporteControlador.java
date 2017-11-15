package ec.com.aereopuerto.controlador;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.com.aereopuerto.modelo.Reserva;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@Named(value = "reporteControlador")
@ViewScoped
public class ReporteControlador extends BaseControlador implements Serializable{

	private static final long serialVersionUID = 4295597100949624998L;

	@PostConstruct
	public void init()
	{
		
	}
	
	public void generarReporteReserva(Reserva reserva)
	{
		try {
			JasperReport jasperReport = JasperCompileManager
		               .compileReport("C:/reporte/reserva.jrxml");
		 
		       // Parameters for report
		       Map<String, Object> parameters = new HashMap<String, Object>();
		 
		       parameters.put("CodigoReserva", reserva.getNumeroRs());
		       // DataSource
		       // This is simple example, no database.
		       // then using empty datasource.
		       JRDataSource dataSource = new JREmptyDataSource();
		 
		       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
		               parameters, dataSource);
		 
		    
		       // Make sure the output directory exists.
		       File outDir = new File("C:/jasperoutput");
		       outDir.mkdirs();
		 
		       JRPdfExporter exporter = new JRPdfExporter();
		       
		        ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		        // ExporterInput
		        exporter.setExporterInput(exporterInput);
		 
		        // ExporterOutput
		        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
		                "C:/jasperoutput/FirstJasperReport.pdf");
		        // Output
		        exporter.setExporterOutput(exporterOutput);
		 
		        //
		        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		        exporter.setConfiguration(configuration);
		        exporter.exportReport();
		 
		        System.out.print("Done Exported!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
