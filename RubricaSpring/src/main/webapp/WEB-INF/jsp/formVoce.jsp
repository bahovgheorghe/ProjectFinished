<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="aggiungiVoce" method="post">
		Nome<input type="text" name="nome" placeholder="nome"/><br>
		Cognome<input type="text" name="cognome" placeholder="cognome"/><br>
		Cell.<input type="text" name="telefono" placeholder="telefono"/><br>
		<input type="submit" value="registra!"/>
	</form>
	<a href="../RubricaSpring/index.jsp">Back Home</a>
</body>
</html>