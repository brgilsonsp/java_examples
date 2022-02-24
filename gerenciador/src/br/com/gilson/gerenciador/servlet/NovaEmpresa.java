package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gilson.gerenciador.model.Empresa;
import br.com.gilson.gerenciador.repository.Banco;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/nova_empresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaString = request.getParameter("dataAbertura");
		Date dataAbertura = null;
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = dateFormat.parse(dataAberturaString);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa);
		
		System.out.println("Cadastrando a empresa " + empresa.getNome());
		
		//redirect client side
		response.sendRedirect("lista_empresas");
		
		// Redirect server side
		//RequestDispatcher dispatcher = request.getRequestDispatcher("nova_empresa_criada.jsp"); // direciona para um JSP
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/lista_empresas"); // direcionar outro serlvet
		//dispatcher.forward(request, response);
		
	}

}
