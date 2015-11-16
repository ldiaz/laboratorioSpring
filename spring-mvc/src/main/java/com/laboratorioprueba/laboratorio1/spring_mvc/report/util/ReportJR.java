package com.laboratorioprueba.laboratorio1.spring_mvc.report.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;


public class ReportJR {
	private ReportJR() {
	}

	/**
	 */
	public static byte[] printReport(final File filejrxml, Map<String, Object> param, final Connection conn, String reportFormat)
			throws IOException, NamingException, SQLException, JRException {

		final JasperPrint jasperPrintTemp = getJasperPrint(filejrxml, param, conn);

		JasperPrintManager.printReport(jasperPrintTemp, false);
		JRExporter exporter = getJREXporter(reportFormat);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrintTemp);
		exporter.exportReport();

		return byteArrayOutputStream.toByteArray();
	}

	private static JRExporter getJREXporter(final String extension) {
		if ("pdf".equalsIgnoreCase(extension)) {
			JRPdfExporter exporter = new JRPdfExporter();
//			exporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print();");
			
			return exporter;
			
		} else if ("html".equalsIgnoreCase(extension)) {
			return new JRHtmlExporter();
			
		} else if ("xls".equalsIgnoreCase(extension)) {
			 JRXlsExporter exporterXLS = new JRXlsExporter();                
			 exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
			 exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
			 exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			 exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			
			return exporterXLS;
			
		} else if ("txt".equalsIgnoreCase(extension)) {
			return new JRTextExporter();
		} else if ("csv".equalsIgnoreCase(extension)) {
			return new JRCsvExporter();
		} else if ("docx".equalsIgnoreCase(extension)) {
			return new JRDocxExporter();
		}
		return null;
	}

	/**
	 * 
	 * @param archivojrxml
	 * @param parametros
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws JRException
	 */
	private static JasperPrint getJasperPrint(File filejrxml, Map<String, Object> param, final Connection conn)
			throws NamingException, SQLException, FileNotFoundException, JRException {
		// Obtiene la conexion del datasource

		//
		conn.setHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);
		// Generar un Inpustream del archivo JRXML
		final InputStream inputStreamJR = new FileInputStream(filejrxml);
		// comopila el reporte
		final JasperReport reportCompiled = JasperCompileManager.compileReport(inputStreamJR);

		return JasperFillManager.fillReport(reportCompiled, param, conn);
	}

}
