<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.open4job.model.vo.EstacionServicioVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
EstacionServicioVO estacion = (EstacionServicioVO)request.getAttribute("Estacionamiento");
%>
<h1><%out.println(estacion.getId());%></h1>
<h1><%out.println(estacion.getTitle());%></h1>
<h1><%out.println(estacion.getFecha());%></h1>
<h1><%out.println(estacion.getCor_x());%></h1>
<h1><%out.println(estacion.getCor_y());%></h1>
<h1><%out.println(estacion.getIcon());%></h1>
</body>
</html>