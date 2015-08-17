<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="wrap">
		<c:forEach items="${combinacoesVotos}" var="combinacao">
			<div class="votacao">          
				<div class="produto">
					<img src='<c:url value="/resources/imgs/restaurantes/${combinacao.primeiroRestaurante.abrev}.jpg"/>'/>
				</div>
				<div class="produto">
					<img src='<c:url value="/resources/imgs/restaurantes/${combinacao.segundoRestaurante.abrev}.jpg"/>'/>
				</div>
			</div>
		</c:forEach>
	</div>
</div> 