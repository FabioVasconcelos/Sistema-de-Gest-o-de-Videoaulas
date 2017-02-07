package web;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import util.ConexaoUtil;
import util.UtilException;
@WebServlet("/RelatServlet")
public class RelatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
		String nomeRelat = request.getParameter("nomeRelat");

		Map<String, Object> parametros = montarMapa(request, nomeRelat);
		
		byte[] bytes = null;
		
		try {
			Connection conn = ConexaoUtil.getConexao();
			
			String nome = getServletContext().getRealPath("/WEB-INF/relatorios/"+nomeRelat+".jasper");
			
			JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(nome);
			
			bytes = JasperRunManager.runReportToPdf(relatorioJasper, parametros, conn);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (UtilException e) {
			e.printStackTrace();
		}
		
		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}
	}
	
	private Map<String, Object> montarMapa(HttpServletRequest request, String nome) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if (nome.equalsIgnoreCase("relatorio")) {
			Double aux = Double.parseDouble(request.getParameter("faixa1"));
			parametros.put("faixa1", aux);
			Double aux2 = Double.parseDouble(request.getParameter("faixa2"));
			parametros.put("faixa2", aux2);
		}
		
		return parametros;
	}
	
	
}
