package br.com.voteNoRestaurante.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.dao.usuario.UsuarioDAO;
import br.com.voteNoRestaurante.model.dao.voto.VotoDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.model.domain.Voto;
import br.com.voteNoRestaurante.utils.VotoModel;
import br.com.voteNoRestaurante.utils.VotosModelWrapper;

/**
 * Serviço para processamento das ações do usuário (votação e cadastro)
 * 
 * @author danilo.possarle
 */
@Repository
public class ProcessamentoService {

	@Autowired
	private RestauranteDAO restauranteDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private VotoDAO votoDAO;
	
	/**
	 * Processa o model de votos transformando-o na entidade
	 * 
	 * @param votosModelWraper {@link VotosModelWrapper}
	 * @return {@link List} de {@link Voto}s do usuário
	 */
	@Transactional
	public List<Voto> processVotos(VotosModelWrapper votosModelWraper){
		List<Voto> votos = new ArrayList<Voto>();
		for (VotoModel votoModel : votosModelWraper.getVotosModel()) {
			Voto voto = new Voto();
			voto.setRestaurante(this.restauranteDAO.findByNome(votoModel.getRestaurante()));
			voto.setQuantidadeVotos(new Long(votoModel.getQuantidade()));
			votos.add(voto);
		}
		return votos;
	}

	/**
	 * Sava o usuário informado
	 * 
	 * @param usuario {@link Usuario}
	 */
	public void save(Usuario usuario) {
		this.usuarioDAO.save(usuario);
	}

	/**
	 * Sava o voto informado
	 * 
	 * @param voto {@link Voto}
	 */
	public void save(Voto voto) {
		this.votoDAO.save(voto);
	}
	
}
