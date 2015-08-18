package br.com.voteNoRestaurante.model.domain;

/**
 * Entidade responsável por armazenar a quantidade de votos de um usuário para
 * um determinado restaurante
 * 
 * @author danilo.possarle
 */
public class Voto extends Persistable {

	private Restaurante restaurante;

	private Integer quantidadeVotos;

	private Usuario usuario;

	/**
	 * @return the restaurante
	 */
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante
	 *            the restaurante to set
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * @return the quantidadeVotos
	 */
	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}

	/**
	 * @param quantidadeVotos
	 *            the quantidadeVotos to set
	 */
	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
