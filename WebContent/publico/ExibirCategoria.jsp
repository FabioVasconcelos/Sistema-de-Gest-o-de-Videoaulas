<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Categoria"%>

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
      
      		<%
			List<Categoria> lista = (List<Categoria>) request.getAttribute("listaCategoria");
			if (lista.isEmpty()) {
			%>
			<p>Não há Categorias no banco de dados</p>
			<%
			}
			else {
			%>
			<table>			
				
			<%
				for (Categoria x:lista) {
			%>	
				<tr>
					<td><a href="<%=request.getContextPath()%>/publico/ExibirCursos?idCategoria=<%=x.getIdCategoria()%>"><%=x.getDescricao()%></a></td>
					
				</tr>
			<%
				}
			%>
			</table>
			<%
			}
			%>
      
      
      
      
      </div>

      <div class="span-18 last">
        <h6>Listar produtos</h6>
        <p></p>
      </div>
      <hr>
      <hr class="space">
      


</div>
</body>
</html>