<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form modelAttribute="usuario" action="usuarios/executarCadastro">
	<label for="nome">Nome:</label>
	<sf:input path="nome" /> <sf:errors path="nome" cssClass="erro"/>
	
	<label for="email">Email:</label>
	<sf:input path="email" /> <sf:errors path="email" cssClass="erro"/>
	
	<input type="submit" value="Confirmar votos" />
</sf:form>