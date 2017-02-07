<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Curso"%>
<%@page import="Modelo.Carrinho"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%

if(session.getAttribute("Carrinho") != null) {
	
	Carrinho carrinho = (Carrinho) session.getAttribute("Carrinho");
	if(carrinho != null)
	{
		
		
		
		List<Curso> x = carrinho.getLista();
		
		
		for(Curso curso : x)
		{
			out.println(curso.getNome() + "<br>");
		}
		%>
		
		
		
		<% 
	}
	else
	{
        %>
		
		Nulo
		
	<% 
		
	}
	
}	

    %>
</body>
</html>
