package br.com.voteNoRestaurante.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidade que representa um usuário dentro da aplicação
 * 
 * @author danilo.possarle
 */
@Entity
@Table(name="USUARIO") 
public class Usuario extends Persistable {
	
	private String nome;
	
	private String email;
	
	private Long id;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "COD_USUARIO")
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
	 * @return the nome
	 */
	@Size(min=3, max=100, message="Nome deve ter tamanho entre 3 e 100.")
	@NotNull
	@NotEmpty(message="O campo nome é obrigatório.")
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
	 * @return the email
	 */
	@Email(message="O e-mail informado não é válido.")
	@NotNull 
	@NotEmpty
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
