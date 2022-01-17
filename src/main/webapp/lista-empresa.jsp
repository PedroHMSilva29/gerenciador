<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.pehenmo.gerenciador.entities.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller?acao=remover" var="removeEmpresa" />
<c:url value="/controller?acao=mostrar" var="mostraEmpresa" />
<c:url value="/index.jsp" var="index" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas</title>
</head>
<body>

<c:if test="${not empty empresa}">
	<p>Sucesso em cadastrar a empresa com Expression Language ${ empresa } !!! </p>
</c:if>

<c:if test="${empty empresa}">
</c:if>

<h2> Lista de empresas </h2> 
<ul>
<c:forEach items="${empresas}" var="empresa">

	<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> 
	<a href="${removeEmpresa}&id=${empresa.id}"> Apagar</a>
	<a href="${mostraEmpresa}&id=${empresa.id}"> Alterar</a>
	</li>
</c:forEach>

</ul>
<a href="${index}"> voltar</a>
</body>	
</html>