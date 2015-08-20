package br.com.voteNoRestaurante.services;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.dao.usuario.UsuarioDAO;
import br.com.voteNoRestaurante.model.dao.voto.VotoDAO;
import br.com.voteNoRestaurante.model.domain.Voto;
import br.com.voteNoRestaurante.utils.VotosModelWrapper;

/**
 * Teste unitário para {@link ProcessamentoService}
 * 
 * @author danilo.possarle
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessamentoServiceTest extends AbstractServiceTest {

	@Mock
	private RestauranteDAO restauranteDAO;
	
	@Mock
	private UsuarioDAO usuarioDAO;
	
	@Mock
	private VotoDAO votoDAO;
	
	@InjectMocks
	private ProcessamentoService processamentoService;
	
	@Test
	public void testProcessVotos() {
		when(this.restauranteDAO.findByNome(NOME_MC_DONALDS)).thenReturn(MCDONALDS);
		when(this.restauranteDAO.findByNome(NOME_SUBWAY)).thenReturn(SUBWAY);
		when(this.restauranteDAO.findByNome(NOME_HABIBS)).thenReturn(HABIBS);
		
		VotosModelWrapper wrapper = new VotosModelWrapper();
		wrapper.setVotosModel(asList(this.createVotoModel(NOME_MC_DONALDS, QTDE_VOTOS_MC),
									this.createVotoModel(NOME_SUBWAY, QTDE_VOTOS_SUB),
									this.createVotoModel(NOME_HABIBS, QTDE_VOTOS_HAB)));
		
		this.verificaVotos(this.processamentoService.processVotos(wrapper));
		
		
	}
	
	/**
	 * Verifica se os 3 restaurantes tiveram seus votos processados.
	 * 
	 * @param votos {@link List} {@link Voto}s
	 */
	private void verificaVotos(List<Voto> votos) {
		boolean containsVotosMcDonalds = false;
		boolean containsVotosHabibs = false;
		boolean containsVotosSubway = false;
		
		for (Voto voto : votos) {
			if(voto.getRestaurante().equals(MCDONALDS)){
				containsVotosMcDonalds = true;
				assertEquals(voto.getQuantidadeVotos(), new Long(QTDE_VOTOS_MC));
				continue;
			}
			if(voto.getRestaurante().equals(HABIBS)){
				containsVotosHabibs = true;
				assertEquals(voto.getQuantidadeVotos(), new Long(QTDE_VOTOS_HAB));
				continue;
			}
			if(voto.getRestaurante().equals(SUBWAY)){
				containsVotosSubway = true;
				assertEquals(voto.getQuantidadeVotos(), new Long(QTDE_VOTOS_SUB));
				continue;
			}
		}
		
		assertTrue("Não foi encontrado votos para McDonalds", containsVotosMcDonalds);
		assertTrue("Não foi encontrado votos para Habibs", containsVotosHabibs);
		assertTrue("Não foi encontrado votos para Subway", containsVotosSubway);
		
	}
	
}
