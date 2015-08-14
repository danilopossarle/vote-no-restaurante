package br.com.voteNoRestaurante.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.domain.Persistable;

/**
 * {@link DAO} genérico
 * 
 * @author danilo.possarle
 * @param <BO> do tipo {@link Persistable}
 */
@Repository
public class GenericDAO<BO extends Persistable> implements DAO<BO> {

	private EntityManagerFactory emf;

	/**
	 * @param emf the emf to set 
	 */
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * @return the {@link EntityManager}
	 */
	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<BO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BO findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BO findByNaturalKey(Serializable naturalKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(BO entity) {
		this.getEntityManager().persist(entity);
	}

}
