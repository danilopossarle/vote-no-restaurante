package br.com.voteNoRestaurante.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe abstrata de persistência que deve ser extendida por todas as entidades do sistema
 * 
 * @author danilo.possarle
 */
@MappedSuperclass
public abstract class Persistable implements Serializable {
	
	private Long id;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "COD")
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
	
}
