<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="content">
	<div class="wrap">
		<div class="success" id="feedback"><p>Obrigado por contribuir com o projeto!</p><br/></div>
		<p>Informe abaixo seus dados para que possamos armazenar suas escolhas:</p><br/>
		<sf:form modelAttribute="usuario" action="executarCadastro" method="POST">
		<div class="form">
			<table>
				<tr>
					<td><label for="nome">Nome:</label></td>
					<td>
						<sf:errors path="nome" cssClass="error"/><br/>
						<sf:input path="nome" />
					</td>
				</tr>
				<tr>
					<td><label for="email">Email:</label></td>
					<td>
						<sf:errors path="email" cssClass="error"/><br/>
						<sf:input path="email" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Confirmar votos" /></td>
				</tr>
			</table>
		</div>
		</sf:form>
	</div>
</div>