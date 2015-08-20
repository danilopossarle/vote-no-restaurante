package br.com.voteNoRestaurante.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.domain.Restaurante;
import br.com.voteNoRestaurante.utils.HomeModel;

/**
 * Classe utilitária para gerar as combinações de restaurantes a serem exibidos para votação
 * 
 * @author danilo.possarle
 */
@Repository
public class HomeService {
	
	@Autowired
	private RestauranteDAO restauranteDAO;
	
	/**
	 * Gera as combinações possíveis para uma lista de {@link Restaurante}s
	 * 
	 * @param restaurantes os {@link Restaurante}s a serem combinados
	 * @return {@link List} de {@link HomeModel}
	 */
	public List<HomeModel> generateCombinations(){
		List<HomeModel> combinations = new ArrayList<HomeModel>();
		List<Restaurante> restaurantes = this.findAllRestaurantes();
		for (int i=0; i< restaurantes.size(); i++) {
		   for (int j = i+1; j < restaurantes.size(); j++) {
		      combinations.add(new HomeModel(restaurantes.get(i), restaurantes.get(j)));
		   }
		}
		Collections.shuffle(combinations, new Random());
		return combinations;
	}

	/**
	 * Recupera todos os restaurantes cadastrados
	 * 
	 * @return {@link List} de todos os {@link Restaurante}s
	 */
	private List<Restaurante> findAllRestaurantes() {
		return this.restauranteDAO.findAll();
	}
}
