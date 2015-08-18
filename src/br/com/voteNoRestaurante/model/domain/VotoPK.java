package br.com.voteNoRestaurante.model.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable 
public class VotoPK {
	
	private Restaurante restaurante;
	
	private Usuario usuario;
	
	/**
	 * @return the restaurante
	 */
	@JoinColumn(name="ID", nullable = false)
	@ManyToOne
	public Restaurante getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	/**
	 * @return the usuario
	 */
	@JoinColumn(name="ID", nullable = false)
	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
