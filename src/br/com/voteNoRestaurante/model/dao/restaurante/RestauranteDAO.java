package br.com.voteNoRestaurante.model.dao.restaurante;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.DAO;
import br.com.voteNoRestaurante.model.dao.GenericDAO;
import br.com.voteNoRestaurante.model.domain.Restaurante;

/**
 * {@link DAO} para {@link Restaurante}
 *  
 * @author danilo.possarle
 */
@Repository
public class RestauranteDAO extends GenericDAO<Restaurante> {

	public Restaurante findByNome(String nome) {
		Session session = this.getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(Restaurante.class);
		criteria.add(Restrictions.eq("nome", nome));
		return (Restaurante) criteria.uniqueResult();
	}

}
