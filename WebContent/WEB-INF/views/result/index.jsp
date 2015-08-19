<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content">
	<div class="wrap">
		<div id="feedback"></div>
		<div id="accordion">
			<h3>Ranking pessoal</h3>
			<div>
				<div id="highchartsRankingUsuario" class="highcharts"></div>
				<table class="tableResults" id="dataUsuario">
					<thead>
						<tr>
							<th></th>
							<c:forEach items="${rankingUsuario}" var="ranking">
								<th>${ranking.nomeRestaurante}</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<c:forEach items="${rankingUsuario}" var="ranking">
								<td>${ranking.qtdeVotos}</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
			<h3>Ranking Geral</h3>
			<div>
				<div id="highchartsRankingGeral" class="highcharts"></div>
				<table class="tableResults" id="dataGeral">
					<thead>
						<tr>
							<th></th>
							<c:forEach items="${rankingGeral}" var="ranking">
								<th>${ranking.nomeRestaurante}</th>
							</c:forEach>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<c:forEach items="${rankingGeral}" var="ranking">
								<td>${ranking.qtdeVotos}</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>