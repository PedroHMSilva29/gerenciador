
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controller?acao=alterar" var="alteraEmpresa" />
<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" var="dataAberturaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de servlets na Alura</title>
</head>
<body>
<form action="${alteraEmpresa}" method="post">
	Nome: <input type="text" name="nome" value="${empresa.nome}" />
	Data Abertura: <input type="text" name="dataAbertura" value="${dataAberturaEmpresa}" /> 
	<input type="hidden" name="id" value="${empresa.id}" /> 
	<input type="submit"/>
</form>
</body>
</html>