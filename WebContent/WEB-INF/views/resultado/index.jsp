<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${restaurantes}" var="restaurante">
	<img class="miniaturaRestaurante" src="/restaurantes/miniaturas/${restaurante.abrev}"/>
	<p>Votos: ${restaurante.votos}</p>
</c:forEach>