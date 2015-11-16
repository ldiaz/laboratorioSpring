package com.laboratorioprueba.laboratorio1.spring_mvc.controladores;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laboratorioprueba.laboratorio1.spring_mvc.report.util.ReportJR;

import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/reportes")
public class ReportController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private DataSource dataSource;

	@RequestMapping(value = "/jasper/{jasperId}.{format}")
	public HttpEntity<byte[]> generateDocumentFromJasper(@PathVariable String jasperId,
			@PathVariable String format,
			@RequestParam Map<String, Object> params) throws IOException, DocumentException, IllegalAccessException,
					InvocationTargetException, NoSuchMethodException, NamingException, SQLException, JRException {

		// resourceLoader.getResource("classpath:static/js/modules/reports/reports.app.js");
		Resource banner = resourceLoader.getResource("classpath:jasper/" + jasperId + ".jrxml");
		banner.getFile();

		if(format.equalsIgnoreCase("xls")){
			final byte[] xlsDataResult;
			xlsDataResult = ReportJR.printReport(banner.getFile(), params, dataSource.getConnection(), format);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "vnd.ms-excel"));
			header.set("Content-Disposition", "attachment; filename=" + jasperId + ".xls");

			header.setContentLength(xlsDataResult.length);

			return new HttpEntity<byte[]>(xlsDataResult, header);
		}else {
			final byte[] pdfDataResult;	
			pdfDataResult = ReportJR.printReport(banner.getFile(), params, dataSource.getConnection(), format);

			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "pdf"));
			header.set("Content-Disposition", "inline; filename=" + jasperId + ".pdf");
			header.setContentLength(pdfDataResult.length);

			return new HttpEntity<byte[]>(pdfDataResult, header);
		}
		
		
	}
	
}
