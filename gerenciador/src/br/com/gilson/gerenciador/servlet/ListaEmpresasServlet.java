package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gilson.gerenciador.model.Empresa;
import br.com.gilson.gerenciador.repository.Banco;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/lista_empresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("lista_empresas.jsp");
		dispatcher.forward(request, response);
		
	}

}
