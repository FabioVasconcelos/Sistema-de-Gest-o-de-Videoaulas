<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Curso"%>
<%@page import="Modelo.Categoria"%>
<%@page import="Modelo.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/screen.css"
	type="text/css" media="screen, projection">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/forms.css"
	type="text/css" media="screen, projection">
</head>
<body>
	<div class="container">


		<div class="span-24 last">

			<img
				src="<%=request.getContextPath()%>/resources/img/logo_eletrofabio2012.jpg" />
		</div>
		<hr>
		<div class="span-4 " style="background-color: #F4F4F4">
			<%@ include file="/resources/template/lateral.jsp"%>
		</div>

		<div class="span-18 last">

			<h2>Olá Administrador</h2>
			<br>
			<%
			List<Curso> lista = (List<Curso>) request.getAttribute("ListaCursos");
			if (lista.isEmpty()) {
			%>
			<p>Não há cursos no banco de dados</p>
			<%
			}
			else {
			%>
			<table>
				<tr>
				    <th>Código:</th>
					<th>Nome:</th>
					<th>Preço:</th>
					<th>Duração (Minutos)</th>
					<th>Editar</th>
					<th>Excluir</th>
					<th>Adicionar Aulas</th>
				</tr>


				<%
				for (Curso x:lista) {
			%>
				<tr>
				    <td><%=x.getIdCurso() %></td>
					<td><%=x.getNome() %></td>
					<td><span style="color: red"> <%=x.getPreco() %></span></td>
					<td><%=x.getDuracao() %></td>
                    <td><a href="<%=request.getContextPath()%>/operador/GerirCursos?cmd=EditarCurso&idCurso=<%=x.getIdCurso()%>"><img src="<%=request.getContextPath()%>/resources/img/alterar.png"></a></td>
                    <td><a href="<%=request.getContextPath()%>/operador/GerirCursos?cmd=excluir&idCurso=<%=x.getIdCurso()%>"><img src="<%=request.getContextPath()%>/resources/img/excluir.gif"></a></td>
                    <td><a href="<%=request.getContextPath()%>/operador/GerirCursos?cmd=addAula&idCurso=<%=x.getIdCurso()%>"><img src="<%=request.getContextPath()%>/resources/img/add.png"></a></td>
				</tr>


				<%
				}
			%>
			</table><br>
			
			<table>
			<tr>
				    <th></th>
					<th></th>
			</tr>		
			<tr><td><a href="<%=request.getContextPath()%>/operador/GerirCursos?cmd=novo">Adicionar novo curso</a></td>
			<td><a href="<%=request.getContextPath()%>/Relatorio.jsp">Relatório de Preço por faixa</a></td></tr>
			
			</table>
			<%
			}
			%>
		</div>





	

		

	</div>
	<hr>
	<hr class="space">
</body>
</html>