package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rn.CarrinhoRN;
import rn.CursoRN;

import Modelo.Carrinho;
import Modelo.Curso;




@WebServlet("/publico/MeuCarrinho")
public class MeuCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        HttpSession sessao = request.getSession(true);		
		
		
		Carrinho carrinho = (Carrinho) sessao.getAttribute("Carrinho");
		if (carrinho==null) {
			carrinho = new Carrinho();
			sessao.setAttribute("Carrinho", carrinho);
		}
		
					
		if(request.getParameter("cmd").equals("inserir")) { {
			CursoRN crn = new CursoRN();
			
			int x = Integer.parseInt(request.getParameter("idCurso"));
			Curso curso = crn.buscaCursoPorId(x);	
			String link = "/publico/CarrinhoVisualizar.jsp";
			CarrinhoRN rn = new CarrinhoRN();
			rn.inserir(curso, carrinho);
			double totalPedido;
			totalPedido = rn.totalPedido(carrinho);
			sessao.setAttribute("Carrinho", carrinho);
			sessao.setAttribute("TotalPedido", totalPedido);
			RequestDispatcher rd = request.getRequestDispatcher(link);
			rd.forward(request, response);
		}
		
		if(request.getParameter("cmd").equals("visualizar")) { 
			RequestDispatcher rd = request.getRequestDispatcher("/publico/CarrinhoVisualizar.jsp");
			rd.forward(request, response);
		}
		
		}
	}
		


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}
	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	processRequest(request, response);
	
	
    }




}





	

		


