package br.com.voteNoRestaurante.model.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * Entidade responsável por armazenar a quantidade de votos de um usuário para
 * um determinado restaurante
 * 
 * @author danilo.possarle
 */
@Entity
@Table(name="VOTO")//, uniqueConstraints=@UniqueConstraint(columnNames={"Restaurante", "number"}))
public class Voto extends Persistable {
	
    private VotoPK votoPK;  

	private Integer quantidadeVotos;
	
	private Long id;

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

	/**
	 * @return the votoPK
	 */
	@EmbeddedId
	public VotoPK getVotoPK() {
		return votoPK;
	}

	/**
	 * @param votoPK the votoPK to set
	 */
	public void setVotoPK(VotoPK votoPK) {
		this.votoPK = votoPK;
	}
	
	/**
	 * @return the restaurante
	 */
	@Transient
	public Restaurante getRestaurante() {
		return this.votoPK.getRestaurante();
	}
	
	/**
	 * @param restaurante the restaurante to set
	 */
	public void setRestaurante(Restaurante restaurante) {
		if(this.votoPK == null){
			this.votoPK = new VotoPK();
		}
		this.votoPK.setRestaurante(restaurante);
	}
	
	/**
	 * @return the usuario
	 */
	@Transient
	public Usuario getUsuario() {
		return this.votoPK.getUsuario();
	}
	
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		if(this.votoPK == null){
			this.votoPK = new VotoPK();
		}
		this.votoPK.setUsuario(usuario);
	}
	
}
