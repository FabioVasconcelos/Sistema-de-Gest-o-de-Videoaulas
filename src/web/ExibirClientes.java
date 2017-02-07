package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Cliente;

import rn.ClienteRN;


@WebServlet("/publico/ExibirClientes")
public class ExibirClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteRN crn = new ClienteRN();
		List<Cliente> lista = crn.buscarTodos();
		request.setAttribute("listaCliente", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/publico/ClienteListar.jsp");
		rd.forward(request, response);
	}
}
