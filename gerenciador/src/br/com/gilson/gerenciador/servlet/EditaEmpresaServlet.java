package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gilson.gerenciador.model.Empresa;
import br.com.gilson.gerenciador.repository.Banco;

@WebServlet("/edita_empresa")
public class EditaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = -5670025200607333180L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaString = request.getParameter("dataAbertura");
		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		Date dataAbertura = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			dataAbertura = dateFormat.parse(dataAberturaString);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Banco banco = new Banco();
		
		Empresa empresa = banco.getEmpresaById(idEmpresa);
		String nomeOriginal = empresa.getNome();
		Date dataAberturaOriginal = empresa.getDataAbertura();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		System.out.println(String.format("Alterado a empresa com id %d do nome %s para o nome %s e data abertura de %s para %s", 
										empresa.getId(), 
										nomeOriginal, 
										empresa.getNome(),
										dateFormat.format(dataAberturaOriginal),
										dateFormat.format(empresa.getDataAbertura()))
				);
		
		response.sendRedirect("lista_empresas");
	}

}
