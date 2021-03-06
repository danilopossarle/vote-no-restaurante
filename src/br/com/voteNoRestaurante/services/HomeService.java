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
		if(restaurantes.isEmpty()){
			this.createRestaurantes(restaurantes);
		}
		for (int i=0; i< restaurantes.size(); i++) {
		   for (int j = i+1; j < restaurantes.size(); j++) {
		      combinations.add(new HomeModel(restaurantes.get(i), restaurantes.get(j)));
		   }
		}
		Collections.shuffle(combinations, new Random());
		return combinations;
	}

	/**
	 * Cria os restaurantes na primeira vez que o sistema é acessado.
	 * 
	 * @param restaurantes {@link List} de {@link Restaurante} onde deveram ser 
	 * 						colocados para processamento
	 */
	private void createRestaurantes(List<Restaurante> restaurantes) {
		restaurantes.add(this.createRestaurante("McDonalds", "mc"));
		restaurantes.add(this.createRestaurante("Burger King", "bk"));
		restaurantes.add(this.createRestaurante("Habibs", "hab"));
		restaurantes.add(this.createRestaurante("Outback", "out"));
		restaurantes.add(this.createRestaurante("Subway", "sub"));
	}

	/**
	 * Cria a entidade restaurante
	 * 
	 * @param nome nome do restaurante
	 * @param abrev abreviação do restaurante
	 * @return {@link Restaurante}
	 */
	private Restaurante createRestaurante(String nome, String abrev) {
		Restaurante restaurante = new Restaurante();
		restaurante.setNome(nome);
		restaurante.setAbrev(abrev);
		this.restauranteDAO.save(restaurante);
		return restaurante;
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
