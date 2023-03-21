<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="images/telephone.png">
<link rel="stylesheet" href="diario.css">
</head>
<body>

	<h1 id="contato">Editar Contato</h1>
	<form name="frmContato" action="update">
	<div class="container">
		<table>
		    <tr>
			<td> <input type="text" name="idcon" id="caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>"> </td>
			</tr>
		
			<tr>
			<td> <input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"> </td>
			</tr>
			
			<tr>
			<td> <input type="text" name="telefone" class="Caixa2" value="<%out.print(request.getAttribute("telefone"));%>"> </td>
			</tr>
			
			<tr>
			<td> <input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"> </td>
			</tr>
		</table>
		</div>
		<input type="button" value="Salvar" class="botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>