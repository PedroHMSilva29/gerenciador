
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller?acao=nova" var="novaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste de servlets na Alura</title>
</head>
<body>
<form action="${novaEmpresa}" method="post">
	Nome: <input type="text" name="nome" />
	Data Abertura: <input type="text" name="dataAbertura" /> 
	<input type="submit"/>
</form>
</body>
</html>