package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import rn.CursoRN;

import Modelo.Curso;


@WebServlet("/publico/ExibirCursos")
public class ExibirCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoRN crn = new CursoRN();
		int x = Integer.parseInt(request.getParameter("idCategoria"));
		List<Curso> lista =crn.buscaTodosPorCategoria(x);
		request.setAttribute("listaCursos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/publico/ExibirCursos.jsp");
		rd.forward(request, response);		
	}

}
