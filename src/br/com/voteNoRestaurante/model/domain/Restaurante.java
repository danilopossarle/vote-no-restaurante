package br.com.voteNoRestaurante.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidade que representa um restaurante dentro da aplicação
 * 
 * @author danilo.possarle
 */
@Entity
@Table(name="RESTAURANTE")
public class Restaurante extends Persistable {

	private String nome;
	
	private String abrev;
	
	private List<Voto> votos;
	
	/**
	 * @return the nome
	 */
	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the abrev
	 */
	@Column(name="ABREV")
	public String getAbrev() {
		return abrev;
	}

	/**
	 * @param abrev the abrev to set
	 */
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	
	/**
	 * @return the votos
	 */
	@OneToMany(mappedBy="restaurante")
	public List<Voto> getVotos() {
		return votos;
	}

	/**
	 * @param votos the votos to set
	 */
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
}
