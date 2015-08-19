package br.com.voteNoRestaurante.utils;

/**
 * Model para exibir os rankings na página de resultado
 * 
 * @author danilo.possarle
 */
public class Ranking {
	
	public String nomeRestaurante;

	public String abrevRestaurante;
	
	public Long qtdeVotos;

	/**
	 * @return the nomeRestaurante
	 */
	public String getNomeRestaurante() {
		return nomeRestaurante;
	}

	/**
	 * @param nomeRestaurante the nomeRestaurante to set
	 */
	public void setNomeRestaurante(String nomeRestaurante) {
		this.nomeRestaurante = nomeRestaurante;
	}

	/**
	 * @return the abrevRestaurante
	 */
	public String getAbrevRestaurante() {
		return abrevRestaurante;
	}

	/**
	 * @param abrevRestaurante the abrevRestaurante to set
	 */
	public void setAbrevRestaurante(String abrevRestaurante) {
		this.abrevRestaurante = abrevRestaurante;
	}

	/**
	 * @return the qtdeVotos
	 */
	public Long getQtdeVotos() {
		return qtdeVotos == null ? 0L : this.qtdeVotos;
	}

	/**
	 * @param qtdeVotos the qtdeVotos to set
	 */
	public void setQtdeVotos(Long qtdeVotos) {
		this.qtdeVotos = qtdeVotos;
	}
	
}