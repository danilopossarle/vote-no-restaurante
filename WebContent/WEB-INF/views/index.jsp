<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
	<div class="wrap">
		<h3>Bem vindo ao projeto Vote no Restaurante!</h3>
		<p>Escolha abaixo o seu restaurante preferido.</p><br/>
		<c:forEach items="${combinacoesVotos}" var="combinacao">
			<div class="votacao">          
				<div class="produto">
					<img src='<c:url value="/resources/imgs/restaurantes/${combinacao.primeiroRestaurante.abrev}.jpg"/>' title="${combinacao.primeiroRestaurante.nome}"/>
				</div>
				<div class="produto">
					<img src='<c:url value="/resources/imgs/restaurantes/${combinacao.segundoRestaurante.abrev}.jpg"/>' title="${combinacao.segundoRestaurante.nome}"/>
				</div>
			</div>
		</c:forEach>
	</div>
</div> 