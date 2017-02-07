package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Modelo.Categoria;
import Modelo.Curso;

import rn.CategoriaRN;
import rn.CursoRN;




@WebServlet("/operador/InserirCursos")
public class InserirCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursoRN crn = new CursoRN(); 
		List<Categoria> cats = new CategoriaRN().buscarTodos();
		request.setAttribute("listarCategorias", cats);
		
		Curso curso = new Curso(); // metodo auxiliar
		
		String aux = request.getParameter("descricao");
		if (aux != null && !aux.equals("")) {
			curso.setDescricao(aux);
		}
		aux = request.getParameter("nome");
		if (aux != null && !aux.equals("")) {
			curso.setNome(aux);
		}
		aux = request.getParameter("preco");
		if (aux != null && !aux.equals("")) {
			curso.setPreco(Integer.parseInt(aux));
		}
		aux = request.getParameter("duracao");
		if (aux != null && !aux.equals("")) {
			curso.setDuracao(Integer.parseInt(aux));
		}
		aux = request.getParameter("categoria");
		if (aux != null && !aux.equals("") && !aux.equals("0")) {
			Categoria cat = new CategoriaRN().buscaPorCodigo(Integer.parseInt(aux));
			curso.setCategoria(cat);
		}
		crn.inserirCurso(curso);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/publico/InserirCursos.jsp"); 
		rd.forward(request, response); 
				
	}
	
	
	
	

}
