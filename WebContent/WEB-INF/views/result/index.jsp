<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="wrap">
		<div id="feedback"></div>
		<c:forEach items="${rankingGeral}" var="ranking">
			<img class="miniaturaRestaurante" src="/restaurantes/miniaturas/${ranking.abrevRestaurante}"/>
			<p>Votos: ${ranking.qtdeVotos}</p>
		</c:forEach>
		<c:forEach items="${rankingUsuario}" var="ranking">
			<img class="miniaturaRestaurante" src="/restaurantes/miniaturas/${ranking.abrevRestaurante}"/>
			<p>Votos: ${ranking.qtdeVotos}</p>
		</c:forEach>
	</div>
</div>