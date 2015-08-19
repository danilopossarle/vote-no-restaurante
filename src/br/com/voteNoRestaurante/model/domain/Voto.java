package br.com.voteNoRestaurante.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Entidade responsável por armazenar a quantidade de votos de um usuário para
 * um determinado restaurante
 * 
 * @author danilo.possarle
 */
@Entity
@Table(name="VOTO", uniqueConstraints=@UniqueConstraint(columnNames={"COD_RESTAURANTE", "COD_USUARIO"}))
public class Voto extends Persistable {
	
	private Long quantidadeVotos;
	
	private Restaurante restaurante;
	
	private Usuario usuario;
	
	/**
	 * @return the restaurante
	 */
	@NotNull
	@JoinColumn(name="COD_RESTAURANTE")
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
	@NotNull
	@JoinColumn(name="COD_USUARIO")
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

	/**
	 * @return the quantidadeVotos
	 */
	@Column(name="QTDE")
	public Long getQuantidadeVotos() {
		return quantidadeVotos;
	}

	/**
	 * @param quantidadeVotos the quantidadeVotos to set
	 */
	public void setQuantidadeVotos(Long quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
}
