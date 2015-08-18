package br.com.voteNoRestaurante.utils;


public class VotoModel {

	private String restaurante;
	
	private Integer quantidade;

	/**
	 * @return the restaurante
	 */
	public String getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
