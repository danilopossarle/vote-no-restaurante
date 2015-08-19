package br.com.voteNoRestaurante.model.dao.voto;

import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.DAO;
import br.com.voteNoRestaurante.model.dao.GenericDAO;
import br.com.voteNoRestaurante.model.domain.Voto;

/**
 * {@link DAO} específico para {@link Voto}
 * 
 * @author danilo.possarle
 */
@Repository
public class VotoDAO extends GenericDAO<Voto> {

	/**
	 * {@inheritDoc}
	 */
	public Class<Voto> getPersistableClass() {
		return Voto.class;
	}
	
}
