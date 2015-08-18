package br.com.voteNoRestaurante.utils.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.domain.Voto;
import br.com.voteNoRestaurante.utils.VotoModel;
import br.com.voteNoRestaurante.utils.VotosModelWraper;

@Repository
public class CadastroService {

	@Autowired
	private RestauranteDAO restauranteDAO;
	
	public List<Voto> processVotos(VotosModelWraper votosModelWraper){
		List<Voto> votos = new ArrayList<Voto>();
		for (VotoModel votoModel : votosModelWraper.getVotosModel()) {
			Voto voto = new Voto();
			voto.setRestaurante(this.restauranteDAO.findByNome(votoModel.getRestaurante()));
			voto.setQuantidadeVotos(votoModel.getQuantidade());
			votos.add(voto);
		}
		return votos;
	}
	
}
