package br.com.gilson.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gilson.gerenciador.model.Phrase;

/**
 * Servlet implementation class OlaMundoScriplet
 */
@WebServlet("/ola_mundo_scriplet/*")
public class OlaMundoScriplet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phrase = request.getParameter("phrase");
		String result = String.format("Voc� digitou a frase \"%s\".", phrase);
		request.setAttribute("result", result);
		request.setAttribute("myPhrases", morePhrases());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ola_mundo_scriplet_result.jsp");
		dispatcher.forward(request, response);
	}
	
	private List<Phrase> morePhrases(){
		List<Phrase> phrases = new ArrayList<>();
		phrases.add(new Phrase("Jesus te ama"));
		phrases.add(new Phrase("Deus � Justo"));
		phrases.add(new Phrase("A Gra�a � para todos"));
		phrases.add(new Phrase("Jesus breve voltar�"));
		phrases.add(new Phrase("Deus � misericodioso"));
		phrases.add(new Phrase("O Esp�rito Santo nos consola"));
		phrases.add(new Phrase("Preciso de Cristo"));
		return phrases;
	}
}
