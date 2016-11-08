<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>n°</th>
				<th>cognome</th>
				<th>nome</th>
				<th>telefono</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="i" value="1" scope="page" />
			<c:forEach items="${voci.lista}" var="v">
				<tr>
					<td><c:out value="${i}" /></td>
					<td><c:out value="${v.cognome}" /></td>
					<td><c:out value="${v.nome}" /></td>
					<td><c:out value="${v.telefono}" /></td>
				</tr>
				<c:set var="i" value="${i + 1}" scope="page" />
			</c:forEach>
		</tbody>
	</table>
	<a href="../RubricaSpring/index.jsp">Back Home</a>
</body>
</html>