<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans"%>
    <%@ page import="java.util.ArrayList"%>
    <%
    
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("contatos");
    for(int i = 0; i < lista.size(); i++){

    }
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agenda de Contatos</title>
<link rel="icon" href="images/telephone.png">
<link rel="stylesheet" href="diario.css">
</head>
<body>
	<img src="images/diary.png" class="center-img">
	<h1>Agenda de Contatos</h1>
	<a href="novoContato.html" class="botao1">Novo Contato</a>
	<a href="report" class="botao2">Relatório</a>
	<table id="tabela">
		<thead>
		<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Telefone</th>
		<th>Email</th>
		<th>Opções</th>
		</tr>
		</thead>
		<tbody>
		<%for(int i = 0; i < lista.size(); i++) { %>
		<tr>
		<td><%=lista.get(i).getIdcon() %></td>
		<td><%=lista.get(i).getNome() %></td>
		<td><%=lista.get(i).getFone() %></td>
		<td><%=lista.get(i).getEmail() %></td>
		<td><a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="botao1">Editar</a>
		<a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)" class="botao2">Excluir</a>
		</td>
		</tr>
		<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>