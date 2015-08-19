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
	
	private Integer quantidadeVotos;
	
	private Long id;
	
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
	 * @return the id
	 */
	@Id
	@Column(name = "COD_VOTO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the quantidadeVotos
	 */
	@Column(name="QTDE")
	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}

	/**
	 * @param quantidadeVotos the quantidadeVotos to set
	 */
	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
}
