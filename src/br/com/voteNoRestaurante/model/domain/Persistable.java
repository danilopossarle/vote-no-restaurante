package br.com.voteNoRestaurante.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

public abstract class Persistable implements Serializable {
	
	public abstract Long getId();
	
}
