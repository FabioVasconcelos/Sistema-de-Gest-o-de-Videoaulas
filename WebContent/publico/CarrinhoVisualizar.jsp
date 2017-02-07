<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Curso"%>
<%@page import="Modelo.Carrinho"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/screen.css" type="text/css" media="screen, projection">

</head>
<body>
  <div class="container">
   
    
     <div class="span-24 last">
     
     	    <img src="<%=request.getContextPath()%>/resources/img/logo_eletrofabio2012.jpg"/>	
     </div>
      <hr>
      <div class="span-4 " style="background-color: #F4F4F4">
       <%@ include file="/resources/template/lateral.jsp"%>
      </div>

      <div class="span-18 last">
     
        <%
		Carrinho carrinho = (Carrinho) session.getAttribute("Carrinho");
		if (carrinho == null) {
		%>
					<p>Carrinho ainda vazio</p>
			
			<%
			}
			else {
				
				Double ValorTotal = (Double)session.getAttribute("TotalPedido");
			%>
			
			
			<table>			
				<tr>										
					<th>Nome:</th>							
					<th>Preço:</th>												
					<th>Duração (Minutos)</th>
				</tr>	
							
				
			<%
				for (int i=0; i < carrinho.getLista().size(); i++) {
					Curso x = carrinho.getLista().get(i);
			%>	
				<tr>
					<td><a href="<%=request.getContextPath()%>/publico/DetalhesCurso?idCurso=<%=x.getIdCurso()%>"><%=x.getNome() %></a></td>			
					<td><span style="color: red">    <%=x.getPreco() %></span></td>
					<td><%=x.getDuracao() %></td>
					
				</tr>
				
			
			<%
				}
			%>
			</table>
			
			
			<h3>Valor total: <% out.println(ValorTotal.toString());%></h3>
			<%
			}
			%>
      </div>
      <hr>
      <hr class="space">
      


</div>
</body>
</html>