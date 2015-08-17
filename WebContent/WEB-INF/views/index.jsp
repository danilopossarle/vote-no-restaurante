<%@page import="br.com.voteNoRestaurante.utils.HomeModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="wrap">
		<c:forEach items="${combinacoesVotos}" var="combinacao">
			<div class="votacao">
				<p>Restaurante 1 ${combinacao.primeiroRestaurante.abrev}</p>
				<p>Restaurante 2 ${combinacao.segundoRestaurante.abrev}</p>
			</div>
		</c:forEach>
	</div>
</div>