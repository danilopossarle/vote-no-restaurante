package br.com.voteNoRestaurante.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.utils.Ranking;

/**
 * Serviço para ações executadas na página de resultados
 * 
 * @author danilo.possarle
 */
@Repository
public class ResultadoService {

	@Autowired
	private RestauranteDAO restauranteDAO;

	/**
	 * Recupera o ranking geral dos restaurantes
	 * 
	 * @return {@link List} de {@link Ranking}
	 */
	public List<Ranking> getRankingGeral() {
		return this.restauranteDAO.getRankingGeral();
	}

	/**
	 * Recupera o ranking de um usuário
	 * 
	 * @param usuario {@link Usuario}
	 * @return {@link List} de {@link Ranking}
	 */
	public List<Ranking> getRankingUsuario(Usuario usuario) {
		return this.restauranteDAO.getRankingUsuario(usuario);
	}
}
