<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Curso"%>
<%@page import="Modelo.Aula"%>

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
</head>
<body>
	<div class="container">


		<div class="span-24 last">

			<img src="<%=request.getContextPath()%>/resources/img/logo_eletrofabio2012.jpg" />
		</div>
		<hr>


		<div class="span-7 colborder">
			<%
			Curso curso = (Curso) request.getAttribute("buscaCursoId");
			if (curso == null) {
			%>
			<p>Não há cursos no banco de dados</p>
			<%
			}
			else {
				
			
		String imgurl = request.getContextPath() + "/resources/img/" + curso.getImgUrl();
		
		%>

			<img src="<%=imgurl %>" width="250" height="250">
		</div>


		<div class="span-14 last">
			
				<h2> 
				
				<% 
				
				out.println(curso.getNome().toString()); 
				
				%>
				
				</h2>
				

				<br>
			

			<%
					
					
					
					out.println("<h4>Duração (Minutos): " + curso.getDuracao() + "</h4>");
					
			%>
			<h4>
				Total de aulas:
				<%
				
				Integer aulas = curso.getAulas().size();
				out.println(aulas.toString());
				
				
				%></h4>
			<h4>
				Preço:
				<%
				
				 Double preco = curso.getPreco();
				 out.println(preco.toString());
				 
				 
				 %></h4>

			<a href="<%=request.getContextPath()%>/publico/MeuCarrinho?cmd=inserir&idCurso=<%=curso.getIdCurso()%>">
				<img src="<%=request.getContextPath()%>/resources/img/adicionar1.png">
			</a>
		</div>

		<br>
		<br>
		<div class="span-18 last">

			<b>Descrição:</b><br>
			<br>
			<%
					
					out.println(curso.getDescricao());
					
			%>

			<br>
			<br>
			<h6>Aulas:</h6>
			<br>
			<%
			List<Aula> lista = curso.getAulas();
			if (lista.isEmpty()) {
			%>
			<p>Não há aulas no banco de dados</p>
			<%
			}
			else {
			%>
			<table>

				<%
				for (Aula x:lista) {
			%>
				<tr>
					<td><%=x.getIdAula()%></td>
					<td><%=x.getDescricao()%></td>
					<td></td>

				</tr>
				<%
				}
			%>
			</table>

			<br>
			<%
			}
			%>


			<%
			}
			%>


		</div>
		<hr>
		<hr class="space">
	</div>
</body>
</html>