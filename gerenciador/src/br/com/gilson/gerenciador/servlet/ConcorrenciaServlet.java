package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/concorrencia")
public class ConcorrenciaServlet extends HttpServlet{

	private static final long serialVersionUID = 8638856342793897047L;
	private Map<String, Integer> totalAccessByName = new HashMap<>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameParameter = req.getParameter("name");
		if(nameParameter != null && !this.totalAccessByName.containsKey(nameParameter)) {
			totalAccessByName.put(nameParameter, 0);
		}else if(nameParameter != null && this.totalAccessByName.containsKey(nameParameter)) {
			Integer totalCount = this.totalAccessByName.get(nameParameter);
			totalCount++;
		}
		
		PrintWriter writer = resp.getWriter();
		writer.println(this.name + " acessou essa página " + this.count + " vezes");
	}
}
