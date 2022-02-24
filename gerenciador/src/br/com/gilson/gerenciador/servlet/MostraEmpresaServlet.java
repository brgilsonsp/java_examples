package br.com.gilson.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gilson.gerenciador.model.Empresa;
import br.com.gilson.gerenciador.repository.Banco;

@WebServlet("/mostra_empresa")
public class MostraEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 6366836790645627042L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.getEmpresaById(id);
		
		req.setAttribute("empresa", empresa);
		
		req.getRequestDispatcher("form_edita_empresa.jsp").forward(req, resp);;
	}

}
