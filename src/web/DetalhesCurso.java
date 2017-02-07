package web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Curso;

import rn.CursoRN;


@WebServlet("/publico/DetalhesCurso")
public class DetalhesCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CursoRN crn = new CursoRN();
		int x = Integer.parseInt(request.getParameter("idCurso"));
		Curso curso = crn.buscaCursoPorId(x);
		request.setAttribute("buscaCursoId", curso);		
		RequestDispatcher rd = request.getRequestDispatcher("/publico/DetalhesCurso.jsp");
		rd.forward(request, response);
		
		
	}



}
