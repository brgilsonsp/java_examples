package br.com.gilson.integration.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.UnexpectedTypeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.NestedServletException;

import br.com.gilson.integration.entity.prop.ConfigurationApiProperties;


@Component
public class AuthorizationAccessFilter implements Filter {
	
	private final Logger logger = LogManager.getLogger(AuthorizationAccessFilter.class);
	
	@Autowired
	private ConfigurationApiProperties propertiesToken;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String tokenSent = this.buildTokenSent(httpRequest);
		try {
			if(tokenSent == null || tokenSent.isEmpty()) {
				String messageBlanck = "Token não informado";
				logger.error(messageBlanck);
				int errorCode = HttpServletResponse.SC_BAD_REQUEST;
				httpResponse.sendError(errorCode, messageBlanck);
				
			}else if(propertiesToken.isTokenValid(tokenSent)) {
				chain.doFilter(request, response);
				
			}else {
				String messageBlanck = "Token inválido";
				logger.error(messageBlanck);
				int errorCode = HttpServletResponse.SC_FORBIDDEN;
				httpResponse.sendError(errorCode, messageBlanck);
			}
			
		}catch(NestedServletException | UnexpectedTypeException validExc) {
			String messageException = "Tipos de campos inválidos. Por favor, verifique os tipos dos campos do corpo da requisição.";
			logger.error(messageException, validExc);
			int errorCode = HttpServletResponse.SC_EXPECTATION_FAILED;
			httpResponse.sendError(errorCode, messageException);
			
		}catch(Exception e) {
			String messageException = "Erro interno do servidor ao processar a requisição";
			logger.error(messageException, e);
			int errorCode = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			httpResponse.sendError(errorCode, messageException);
		}
	}

	private String buildTokenSent(HttpServletRequest httpRequest) {
		String tokenSent = "";
		try {
			tokenSent = httpRequest.getHeader(this.propertiesToken.getKey());
		}catch(Exception e) {
			this.logger.error("Error build Token API sent", e);
		}
		return tokenSent;
	}

}