package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rn.AulaRN;
import rn.CategoriaRN;
import rn.CursoRN;

import Modelo.Aula;
import Modelo.Categoria;
import Modelo.Curso;

@WebServlet("/operador/GerirCursos")
public class GerirCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("cmd").equals("inserir")) {

			InsereCurso(request, response);

		}

		if (request.getParameter("cmd").equals("alterar")) {

			EditaCurso(request, response);

		}

		if (request.getParameter("cmd").equals("listar")) {

			ListaCursos(request, response);

		}

		if (request.getParameter("cmd").equals("excluir")) {

			ExcluiCurso(request, response);

		}

		if (request.getParameter("cmd").equals("novo")) {

			NovoCurso(request, response);

		}

		if (request.getParameter("cmd").equals("EditarCurso")) {

			AlteraCurso(request, response);

		}
		
		if (request.getParameter("cmd").equals("addAula")) {

			AddAula(request, response);

		}

	}
	
	private void AddAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("idCurso");	
		AulaRN aula = new AulaRN();
		
		
	}

	
	private List<String> validarDados(Curso curso) {
		List<String> erros = new ArrayList<String>();
		
		// Atenção: para cada atributo, só estamos verificando se é nulo!

		if (curso.getDescricao() == null) {
			erros.add("Favor preencher a descrição");
		}

		if (curso.getNome()==null) {
			erros.add("Favor preencher o nome");
		}

		if (curso.getCategoria() == null) {
			erros.add("Favor preencher a categoria");
		}

		return erros;
	}
	
	
	private void AlteraCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			CursoRN rn = new CursoRN();
			String id = request.getParameter("idCurso");
			if (id != null || id!= "")
			{
			int cod_curso = Integer.parseInt(id);
			Curso curso = rn.buscaCursoPorId(cod_curso);
			if (curso != null)
			{
				List<Categoria> cats = new CategoriaRN().buscarTodos();
				request.setAttribute("categoriaList", cats);
				request.setAttribute("AlteraCursos", curso);
				
			}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/operador/AlterarCursos.jsp"); 
			rd.forward(request, response); 
			
			
		}	

	private void EditaCurso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CursoRN rn = new CursoRN();
		Curso curso = IntanciaCurso(request);

		List<String> erros = validarDados(curso);
		RequestDispatcher rd = null;
		if (erros.isEmpty()) {
			rn.atualizaCurso(curso);
			rd = request.getRequestDispatcher("/operador/GerirCursos?cmd=listar");
		} else {
			List<Categoria> cats = new CategoriaRN().buscarTodos();
			request.setAttribute("categoriaList", cats);
			request.setAttribute("erros", erros);
			request.setAttribute("curso", curso);
			rd = request.getRequestDispatcher("/operador/AlterarCursos.jsp");
		}
		rd.forward(request, response);
	
	}

	private void NovoCurso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> cats = new CategoriaRN().buscarTodos();
		request.setAttribute("listarCategorias", cats);
		RequestDispatcher rd = request
				.getRequestDispatcher("/operador/InserirCursos.jsp");
		rd.forward(request, response);
	}

	private void InsereCurso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CursoRN crn = new CursoRN();

		Curso curso = IntanciaCurso(request); // metodo auxiliar

	
		crn.inserirCurso(curso);

		RequestDispatcher rd = request
				.getRequestDispatcher("/operador/GerirCursos?cmd=listar");
		rd.forward(request, response);

	}

	
	private Aula IntanciaAula(HttpServletRequest request) {

		Aula aula = new Aula(); // metodo auxiliar
		CursoRN rn = new CursoRN();
		String aux = request.getParameter("idAula");
		if (aux != null && !aux.equals("")) {
			aula.setIdAula(aux);
		}

		aux = request.getParameter("descricao");
		if (aux != null && !aux.equals("")) {
			aula.setDescricao(aux);
		}
		
		aux = request.getParameter("idCurso");
		if (aux != null && !aux.equals("")) {
			
			Curso curso = rn.buscaCursoPorId(Integer.parseInt(aux));
			aula.setCurso(curso);
		}
		return aula;

	}
	
	private Curso IntanciaCurso(HttpServletRequest request) {

		Curso curso = new Curso(); // metodo auxiliar
		
		String aux = request.getParameter("idCurso");
		if (aux != null && !aux.equals("")) {
			curso.setIdCurso(Integer.parseInt(aux));
		}

		aux = request.getParameter("descricao");
		if (aux != null && !aux.equals("")) {
			curso.setDescricao(aux);
		}
		aux = request.getParameter("nome");
		if (aux != null && !aux.equals("")) {
			curso.setNome(aux);
		}
		aux = request.getParameter("preco");
		if (aux != null && !aux.equals("")) {
			curso.setPreco(Double.parseDouble(aux));
		}
		aux = request.getParameter("duracao");
		if (aux != null && !aux.equals("")) {
			curso.setDuracao(Integer.parseInt(aux));
		}
		aux = request.getParameter("categoria");
		if (aux != null && !aux.equals("") && !aux.equals("0")) {
			Categoria cat = new CategoriaRN().buscaPorCodigo(Integer
					.parseInt(aux));
			curso.setCategoria(cat);
		}

		aux = request.getParameter("nomeImagem");
		if (aux != null && !aux.equals("")) {
			curso.setImgUrl(aux);
		}

		return curso;

	}

	private void ExcluiCurso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CursoRN rn = new CursoRN();
		String id = request.getParameter("idCurso");
		if (id != null || id != "") {
			int cod_curso = Integer.parseInt(id);
			Curso curso = rn.buscaCursoPorId(cod_curso);
			if (curso != null) {
				rn.excluiCurso(curso);

				RequestDispatcher rd = request
						.getRequestDispatcher("/operador/GerirCursos?cmd=listar");
				rd.forward(request, response);

			}

		}

	}

	private void ListaCursos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CursoRN rn = new CursoRN();
		List<Curso> lista = rn.buscarTodos();
		if (!lista.isEmpty()) {

			request.setAttribute("ListaCursos", lista);
			RequestDispatcher rd = request
					.getRequestDispatcher("/operador/adm.jsp");
			rd.forward(request, response);
		}

	}

}
