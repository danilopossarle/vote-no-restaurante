package br.com.voteNoRestaurante.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.voteNoRestaurante.model.domain.Restaurante;

/**
 * Classe utilitária para gerar as combinações de restaurantes a serem exibidos para votação
 * 
 * @author danilo.possarle
 */
public class HomeUtils {
	
	/**
	 * Gera as combinações possíveis para uma lista de {@link Restaurante}s
	 * 
	 * @param restaurantes os {@link Restaurante}s a serem combinados
	 * @return {@link List} de {@link HomeModel}
	 */
	public static List<HomeModel> generateCombinations(List<Restaurante> restaurantes){
		List<HomeModel> combinations = new ArrayList<HomeModel>();
		for (int i=0; i< restaurantes.size(); i++) {
		   for (int j = i+1; j < restaurantes.size(); j++) {
		      combinations.add(new HomeModel(restaurantes.get(i), restaurantes.get(j)));
		   }
		}
		Collections.shuffle(combinations, new Random());
		return combinations;
	}
}
