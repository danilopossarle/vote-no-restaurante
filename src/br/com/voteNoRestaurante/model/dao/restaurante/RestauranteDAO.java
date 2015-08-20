package br.com.voteNoRestaurante.model.dao.restaurante;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.DAO;
import br.com.voteNoRestaurante.model.dao.GenericDAO;
import br.com.voteNoRestaurante.model.domain.Restaurante;
import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.utils.Ranking;

/**
 * {@link DAO} para {@link Restaurante}
 *  
 * @author danilo.possarle
 */
@Repository
public class RestauranteDAO extends GenericDAO<Restaurante> {

	/**
	 * Retorna o restaurante com o nome informado
	 * 
	 * @param nome o nome do restaurante a ser recuperado
	 * @return {@link Restaurante}
	 */
	public Restaurante findByNome(String nome) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("nome", nome));
		return (Restaurante) criteria.uniqueResult();
	}
	
	/**
	 * Recupera o ranking geral da votação
	 * 
	 * @return {@link List} de {@link Ranking}
	 */
	@SuppressWarnings("unchecked")
	public List<Ranking> getRankingGeral() {
		Session session = this.getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(this.getPersistableClass(), "r");
		
		// SELECT
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("v.quantidadeVotos"), "qtdeVotos");
		projectionList.add(Projections.groupProperty("r.nome"), "nomeRestaurante");
		projectionList.add(Projections.groupProperty("r.abrev"), "abrevRestaurante");
		criteria.setProjection(projectionList);
		
		// JOINS
		criteria.createCriteria("votos", "v", JoinType.LEFT_OUTER_JOIN);
		
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
		StringBuilder hqlBuilder = new StringBuilder();
		hqlBuilder.append("select r.nome as nomeRestaurante, r.abrev as abrevRestaurante, ");
		hqlBuilder.append("(select sum(v.quantidadeVotos) from Voto v inner join v.usuario u "); 
		hqlBuilder.append("where r.id = v.restaurante.id and u.id = :idUsuario) as qtdeVotos ");
		hqlBuilder.append("from Restaurante r");
		
		Session session = this.getEntityManager().unwrap(Session.class);
		Query query = session.createQuery(hqlBuilder.toString());
		query.setLong("idUsuario", usuario.getId());
		query.setResultTransformer(Transformers.aliasToBean(Ranking.class));
		
		return (List<Ranking>) query.list();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Class<Restaurante> getPersistableClass() {
		return Restaurante.class;
	}

}
