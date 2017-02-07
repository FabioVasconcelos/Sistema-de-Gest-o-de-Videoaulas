package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rn.CursoRN;
import Modelo.Curso;


@WebServlet("/operador/AlterarCurso")
public class AlterarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("cmd").equals("alterar")) {	
			CursoRN rn = new CursoRN();
			String id = request.getParameter("idCurso");
			if (id != null || id!= "")
			{
			int cod_curso = Integer.parseInt(id);
			Curso curso = rn.buscaCursoPorId(cod_curso);
			request.setAttribute("AlterarCurso", curso);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/operador/AlterarCurso.jsp"); 
			rd.forward(request, response); 
			}
			
			
			
			}
		}
	}

	
		

	
	



