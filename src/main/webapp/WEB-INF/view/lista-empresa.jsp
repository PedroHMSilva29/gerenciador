<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.pehenmo.gerenciador.entities.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller?acao=RemoveEmpresa" var="removeEmpresa" />
<c:url value="/controller?acao=MostraEmpresa" var="mostraEmpresa" />
<c:url value="/controller?acao=NovaEmpresa" var="inserir" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas</title>
</head>
<body>

<c:if test="${not empty empresa}">
Sucesso ao cadastrar empresa ${empresa} !
</c:if>

<c:if test="${empty empresa}">

</c:if>

<h2> Lista de empresas </h2> 
<ul>
<c:forEach items="${empresas}" var="empresa">

	<li>(${empresa.id}) ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" /> 
	<a href="${removeEmpresa}&id=${empresa.id}"> Apagar</a>
	<a href="${mostraEmpresa}&id=${empresa.id}"> Alterar</a>
	</li>
</c:forEach>

</ul>
<a href="${inserir}"> inserir</a>
<c:import url="logout-par.jsp" />
</body>	
</html>