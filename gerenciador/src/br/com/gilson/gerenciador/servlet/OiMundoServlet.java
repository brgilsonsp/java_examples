package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Configurado no web.xml
 * 
 * @author brgil
 *
 */
public class OiMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 963633710234934901L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("This is init");
	}
	
	@Override
		public void destroy() {
			super.destroy();
			System.out.println("This is destroy");
		}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("My first servlet!!!!");
		out.println("</body>");
		out.println("</html>");
	}
}
