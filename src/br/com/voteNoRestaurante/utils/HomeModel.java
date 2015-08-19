package br.com.voteNoRestaurante.utils;

import br.com.voteNoRestaurante.model.domain.Restaurante;

/**
 * Model que possuí dois restaurantes para serem votados.
 * 
 * @author danilo.possarle
 */
public class HomeModel {

	private Restaurante primeiroRestaurante;
	
	private Restaurante segundoRestaurante;

	/**
	 * Construtor.
	 * 
	 * @param primeiroRestaurante primeiro {@link Restaurante} da combinação para voto
	 * @param segundoRestaurante segundo {@link Restaurante} da combinação para voto
	 */
	public HomeModel(Restaurante primeiroRestaurante, Restaurante segundoRestaurante) {
		this.primeiroRestaurante = primeiroRestaurante;
		this.segundoRestaurante = segundoRestaurante;
	}

	/**
	 * @return the primeiroRestaurante
	 */
	public Restaurante getPrimeiroRestaurante() {
		return primeiroRestaurante;
	}

	/**
	 * @param primeiroRestaurante the primeiroRestaurante to set
	 */
	public void setPrimeiroRestaurante(Restaurante primeiroRestaurante) {
		this.primeiroRestaurante = primeiroRestaurante;
	}

	/**
	 * @return the segundoRestaurante
	 */
	public Restaurante getSegundoRestaurante() {
		return segundoRestaurante;
	}

	/**
	 * @param segundoRestaurante the segundoRestaurante to set
	 */
	public void setSegundoRestaurante(Restaurante segundoRestaurante) {
		this.segundoRestaurante = segundoRestaurante;
	}

}
