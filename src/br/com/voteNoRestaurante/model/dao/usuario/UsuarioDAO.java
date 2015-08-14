package br.com.voteNoRestaurante.model.dao.usuario;

import org.springframework.stereotype.Repository;

import br.com.voteNoRestaurante.model.dao.GenericDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;

/**
 * {@link DAO} específico para {@link Usuario}
 * 
 * @author danilo.possarle
 */
@Repository
public class UsuarioDAO extends GenericDAO<Usuario> {

}
