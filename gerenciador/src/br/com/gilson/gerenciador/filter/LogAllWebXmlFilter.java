package br.com.gilson.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Configure Web.xml
 * @author brgil
 *
 */
public class LogAllWebXmlFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("ииииииииииииииииииииииииииииии LOG ALL Web.XML ииииииииииииииииииииииииииииии");
		
		chain.doFilter(request, response);
	}

}
