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
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/screen.css" type="text/css" media="screen, projection">
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/forms.css" type="text/css" media="screen, projection">
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
      
   
         <form action="<%=request.getContextPath()%>/RelatServlet?nomeRelat=relatorio" method="post">
    <fieldset>
     <legend>Relatório de preço</legend>
     

		<table>
			<tr>	
			 <td>
			   De:
			
             </td>
                    <td>                    
                    
                    <input type="text" name="faixa1" id="faixa1"/>
                                        
                    </td>
            
           </tr>
				 			
			<tr>
		
			<td>
			   Até:
			
		   </td>
            
            <td><input type="text" name="faixa2" id="faixa2"/>
            </td>
         </tr>
		
		 	 
		 	 <tr>
		 	  <td><input type="submit" name="btInserir" value="Gerar" /></td>
		 	
		 	
		 	 </tr>
		</table>
        </fieldset>
	</form>
      </div>
      <hr>
      <hr class="space">
      


</div>
</body>
</html>
