package br.com.voteNoRestaurante.services;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

import br.com.voteNoRestaurante.model.domain.Restaurante;
import br.com.voteNoRestaurante.utils.VotoModel;

/**
 * Classe abstrata para os testes de serviço
 * 
 * @author danilo.possarle
 */
public abstract class AbstractServiceTest {

	protected static final String NOME_MC_DONALDS = "McDonalds";
	
	protected static final String NOME_SUBWAY = "Subway";
	
	protected static final String NOME_HABIBS = "Habibs";

	protected static final Integer QTDE_VOTOS_MC = 3;

	protected static final Integer QTDE_VOTOS_SUB = 2;

	protected static final Integer QTDE_VOTOS_HAB = 5;

	protected static Restaurante SUBWAY;

	protected static Restaurante MCDONALDS;

	protected static Restaurante HABIBS;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		MCDONALDS = this.createRestaurante(NOME_MC_DONALDS, 1L);
		HABIBS = this.createRestaurante(NOME_HABIBS, 2L);
		SUBWAY = this.createRestaurante(NOME_SUBWAY, 3L);
	}

	/**
	 * Cria uma {@link Restaurante} com o nome e id informados
	 * 
	 * @param nomeRestaurante nome do restaurante
	 * @param id id
	 * @return {@link Restaurante}
	 */
	protected Restaurante createRestaurante (String nomeRestaurante, Long id){
		Restaurante restaurante = new Restaurante();
		restaurante.setId(id);
		restaurante.setNome(nomeRestaurante);
		return restaurante;
	}
	
	/**
	 * Cria uma {@link VotoModel} para o restaurante informado com quantidade 1
	 * 
	 * @param restaurante nome do restaurante
	 * @param quantidade de votos
	 * @return {@link VotoModel}
	 */
	protected VotoModel createVotoModel(String restaurante, Integer qtdeVotos) {
		VotoModel votoModel = new VotoModel();
		votoModel.setQuantidade(qtdeVotos);
		votoModel.setRestaurante(restaurante);
		return votoModel;
	}
}
