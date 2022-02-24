<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.gilson.gerenciador.model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/remove_empresa" var="linkRemoveEmpresaServle" />
<c:url value="/mostra_empresa" var="linkMostraEmpresaServle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - 
				<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="${linkMostraEmpresaServle}?id=${empresa.id}">editar</a>
				<a href="${linkRemoveEmpresaServle}?id=${empresa.id}">remover</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>