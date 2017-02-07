<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Login</title>
</head>
<body>
	<a href="">Registre-se</a>
	<hr />
	<c:if test="${not empty param.erro}">
		<div class="bloco_erro">
			Erro no login. Tente novamente.<br /> Causa :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<form id="login" action="<c:url value='j_spring_security_check' />"
		method="post">
		<fieldset>
			<legend>Dados de logon</legend>
			<label> E-mail:<br /> <input type='text' name='j_username' />
			</label> <br /> <label> Senha:<br /> <input type='password'
				name='j_password' />
			</label> <br /> <label> <input type="checkbox"
				name="_spring_security_remember_me" /> Entrar automaticamente <br />
			</label> <input type="submit" value="Entrar" />
			<script>
				document.getElementById("login").j_username.value = "${SPRING_SECURITY_LAST_USERNAME}";
			</script>
		</fieldset>
	</form>