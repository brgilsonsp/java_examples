<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/edita_empresa" var="linkServletEditaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edita Empresa</title>
</head>
<body>

	<form action="${linkServletEditaEmpresa}" method="post">
		<input type="hidden" value="${empresa.id}" name="id" />		
		Nome: <input type="text" value="${empresa.nome}" name="nome" />
		Data Abertura <input type="text" value='<fmt:formatDate value="${empresa.dataAbertura}"/>' name="dataAbertura" />
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>