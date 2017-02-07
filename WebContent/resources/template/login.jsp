<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.List"%>
<%@page import="Modelo.Curso"%>
<%@page import="Modelo.Categoria"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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

		<div class="span-18 last" style="alignment-adjust: central">
			<c:if test="${not empty param.erro}">
				<div class="bloco_erro">
					Erro no login. Tente novamente.<br /> Causa :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>

			<form id="login" action="<c:url value='j_spring_security_check' />"
				method="post">
				<fieldset>
					<legend>Login</legend>


					<table>
						<tr>
							<td>E-mail:</td>
						<td><input type='text' name='j_username' /></td>

						</tr>

						<tr>
							<td>Senha:</td>
							<td><input type='password' name='j_password' /></td>
						</tr>



						<tr>
							<td></td>
							<td><br>
							<input type="submit" value="Entrar" /></td>
						</tr>


						<tr>
							<td></td>
							<br>
							<td><input type="checkbox"
								name="_spring_security_remember_me" />Entrar automaticamente</td>
						</tr>

					</table>

					<script>
						document.getElementById("login").j_username.value = "${SPRING_SECURITY_LAST_USERNAME}";
					</script>

					<a href="">Ainda não é cadastrado? Clique aqui e se cadastre!</a>
				</fieldset>
			</form>
		</div>
		<hr>
		<hr class="space">
	</div>
</body>
</html>
