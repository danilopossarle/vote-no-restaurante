package br.com.voteNoRestaurante.model.dao;

import java.io.Serializable;
import java.util.List;

import br.com.voteNoRestaurante.model.domain.Persistable;

/**
 * Interface para implementação dos DAOs necessários para a aplicação
 *  
 * @author danilo.possarle
 * @param <BO> do tipo {@link Persistable}
 */
public interface DAO<BO extends Persistable> {
	
	/**
	 * Encontra todos os registros da base
	 * 
	 * @return {@link List} com todos os registros da base
	 */
	List<BO> findAll();
	
	/**
	 * Encontra o registro da base identificado por aquele id
	 * 
	 * @param id o id
	 * @return o registro da base identificado por aquele id
	 */
	BO findById(Serializable id);
	
	/**
	 * Encontra o registro da base identificado por uma natural key
	 * 
	 * @param a natural key
	 * @return o registro da base identificado por uma natural key
	 */
	BO findByNaturalKey(Serializable naturalKey);
	
	/**
	 * Salva a entidade informada
	 * 
	 * @param entity entidade que deve ser salva
	 */
	void save(BO entity);
}
