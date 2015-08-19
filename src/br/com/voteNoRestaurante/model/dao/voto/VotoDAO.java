package br.com.voteNoRestaurante.model.dao.voto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.DAO;
import br.com.voteNoRestaurante.model.dao.GenericDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.model.domain.Voto;
import br.com.voteNoRestaurante.utils.Ranking;

/**
 * {@link DAO} específico para {@link Voto}
 * 
 * @author danilo.possarle
 */
@Repository
public class VotoDAO extends GenericDAO<Voto> {

	/**
	 * Recupera o ranking geral da votação
	 * 
	 * @return {@link List} de {@link Ranking}
	 */
	@SuppressWarnings("unchecked")
	public List<Ranking> getRankingGeral() {
		Session session = this.getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(Voto.class, "v");
		// SELECT
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("v.quantidadeVotos"), "qtdeVotos");
		projectionList.add(Projections.property("r.nome"), "nomeRestaurante");
		projectionList.add(Projections.property("r.abrev"), "abrevRestaurante");
		projectionList.add(Projections.groupProperty("r.nome"));
		criteria.setProjection(projectionList);
		
		// JOINS
		criteria.createCriteria("restaurante", "r");
		
		// ORDER BY
		criteria.addOrder(Order.desc("v.quantidadeVotos"));
		
		criteria.setResultTransformer(Transformers.aliasToBean(Ranking.class));
		
		return (List<Ranking>) criteria.list();
	}
	
	/**
	 * Recupera o ranking por usuário
	 * 
	 * @param usuario {@link Usuario}
	 * @return {@link List} de {@link Ranking}
	 */
	@SuppressWarnings("unchecked")
	public List<Ranking> getRankingUsuario(Usuario usuario) {
		Session session = this.getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(Voto.class, "v");
		// SELECT
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("v.quantidadeVotos"), "qtdeVotos");
		projectionList.add(Projections.property("r.nome"), "nomeRestaurante");
		projectionList.add(Projections.property("r.abrev"), "abrevRestaurante");
		projectionList.add(Projections.groupProperty("r.nome"));		
		criteria.setProjection(projectionList);
		
		// JOINS
		criteria.createCriteria("restaurante", "r");
		Criteria criteriaUsuario = criteria.createCriteria("usuario", "u");
		
		// WHERE
		criteriaUsuario.add(Restrictions.eq("u.id", usuario.getId()));
		
		criteria.setResultTransformer(Transformers.aliasToBean(Ranking.class));
		
		return (List<Ranking>) criteria.list();
	}

}
