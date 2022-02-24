<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List, br.com.gilson.gerenciador.model.Phrase" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Duas formas de escrever o resultado no browser -->
	<p><%= request.getAttribute("result") %></p>
	<p><% out.print(request.getAttribute("result")); %></p>
	
	<ul>
	<%
		List<Phrase> phrases = (List<Phrase>) request.getAttribute("myPhrases");
		for(Phrase phrase : phrases){
			 System.out.println(phrase.getPhrase());
	%>
		<li><%= phrase.getPhrase() %> </li>
	<%
		}
	%>
	</ul>
</body>
</html>