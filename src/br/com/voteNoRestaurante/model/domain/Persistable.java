package br.com.voteNoRestaurante.model.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persistable {
	
	private Long id;

	/**
	 * @return the id
	 */
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
