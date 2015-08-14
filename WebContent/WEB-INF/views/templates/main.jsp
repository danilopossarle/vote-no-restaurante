<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/recursos/css/global.css"/>" />
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="cabecalho"/>
	<tiles:insertAttribute name="conteudo"/>
	<tiles:insertAttribute name="rodape"/>
</body>
</html>