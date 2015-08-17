package br.com.voteNoRestaurante.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
		EntityManager entityManager = this.getEntityManager();
		CriteriaBuilder critBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BO> criteriaQuery = critBuilder.createQuery(this.getPersistableClass());
		Root<BO> variableRoot = criteriaQuery.from(this.getPersistableClass());
		criteriaQuery.select(variableRoot);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BO findById(Serializable id) {
		Session session = this.getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(this.getPersistableClass());
		criteria.add(Restrictions.eq("id", id));
		return (BO) criteria.uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(BO entity) {
		this.getEntityManager().persist(entity);
	}
	
	/**
	 * Recupera a classe do BO
	 * 
	 * @return a classe BO
	 */
	@SuppressWarnings("unchecked")
	private Class<BO> getPersistableClass() {
		return (Class<BO>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
