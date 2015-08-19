<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="wrap">
		<div id="feedback"></div>
		<div id="accordion">
			<h3>Ranking pessoal</h3>
			<div>
				<c:forEach items="${rankingUsuario}" var="ranking">
					<img class="miniaturaRestaurante" src='<c:url value="/resources/imgs/restaurantes/miniaturas/${ranking.abrevRestaurante}.jpg"/>'/>
					<p>Votos: ${ranking.qtdeVotos}</p>
				</c:forEach>
			</div>
			<h3>Ranking Geral</h3>
			<div>
				<c:forEach items="${rankingGeral}" var="ranking">
					<img class="miniaturaRestaurante" src='<c:url value="/resources/imgs/restaurantes/miniaturas/${ranking.abrevRestaurante}.jpg"/>'/>
					<p>Votos: ${ranking.qtdeVotos}</p>
				</c:forEach>
			</div>
		</div>
	</div>
</div>