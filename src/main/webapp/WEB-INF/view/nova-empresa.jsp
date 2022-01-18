
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller?acao=InsereEmpresa" var="novaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir nova empresa</title>
</head>
<body>
<form action="${novaEmpresa}" method="post">
	Nome: <input type="text" name="nome" />
	Data Abertura: <input type="text" name="dataAbertura" /> 
	<input type="submit"/>
	
	<c:import url="logout-par.jsp" />
</form>
</body>
</html>