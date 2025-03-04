<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Lista Prenotazioni</title>
<link href="mioStile.css" rel="Stylesheet">
<style type="text/css">
th, td {
 border-bottom: 1px solid #ddd;
}
tr:nth-child(even) 
{
background-color: rgb(161, 227, 249);
}
th {
  border: 1px solid black;
  background-color: rgb(54, 116, 181);
  color: white;
}
</style>
</head>
<body>
<%
     session.getAttribute("prenotazioni");
%>
	<br><br>
	<table border="1" style="margin-left: 10px;border-radius: 5px;width:98%;text-align: center;border-collapse: collapse;">
	<tr>
	<th>ID</th>
	<th>Nome</th>
	<th>Cognome</th>
	<th>Codice Fiscale</th>
	<th>Compagnia Aerea</th>
	<th>N. Adulti</th>
	<th>N. Bambini</th>
	<th>Partenza</th>
	<th>Destinazione</th>
	<th>Data Partenza</th>
	<th>Data Arrivo</th>
	<th>Prezzo</th>
	<th>Bagaglio</th>
	<th>Annulla</th>
	</tr>
	<c:forEach var="prenotazione" items="${prenotazioni}">
		<tr>
			<td>${prenotazione.id}</td>		
			<td>${prenotazione.nomeCliente}</td>
			<td>${prenotazione.cognomeCliente}</td>
			<td>${prenotazione.cfCliente}</td>
			<td>${prenotazione.compagniaAerea}</td>
			<td>${prenotazione.nAdulti}</td>
			<td>${prenotazione.nBambini}</td>
			<td>${prenotazione.partenza}</td>
			<td>${prenotazione.destinazione}</td>
			<td>${prenotazione.dataPartenza}</td>
			<td>${prenotazione.dataArrivo}</td>
			<td>${prenotazione.importoPagato}</td>
			<td>${prenotazione.bagaglio}</td>
			<td><a href="Avvio?scelta=3&id=${prenotazione.id}"><button>Annulla</button></a></td>						
		</tr>
	</c:forEach>
 	</table>
</body>
</html>