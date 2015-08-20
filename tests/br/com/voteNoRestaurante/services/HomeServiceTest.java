package br.com.voteNoRestaurante.services;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.utils.HomeModel;


/**
 * Teste unitário para {@link HomeService}
 * 
 * @author danilo.possarle
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeServiceTest extends AbstractServiceTest {

	@Mock
	private RestauranteDAO restauranteDAO;

	@InjectMocks
	private HomeService homeService;
	
	@Test
	public void testGenerateCombinations() {
		when(restauranteDAO.findAll()).thenReturn(asList(MCDONALDS, HABIBS, SUBWAY));
		boolean hasMcDonaldsSubwayCombination = false;
		boolean hasMcDonaldsHabibsCombination = false;
		boolean hasHabibsSubwayCombination = false;
		
		List<HomeModel> combinations = this.homeService.generateCombinations();
		
		assertTrue("Deve possui 3 combinações", combinations.size() == 3);
		
		for (HomeModel combination : combinations) {
			boolean isCombinationMcDonaldsSubway = combination.getPrimeiroRestaurante().equals(MCDONALDS) && combination.getSegundoRestaurante().equals(SUBWAY);
			if(isCombinationMcDonaldsSubway) {
				hasMcDonaldsSubwayCombination = true;
				continue;
			}
			
			boolean isCombinationMcDonaldsHabibs = combination.getPrimeiroRestaurante().equals(MCDONALDS) && combination.getSegundoRestaurante().equals(HABIBS);
			if(isCombinationMcDonaldsHabibs) {
				hasMcDonaldsHabibsCombination = true;
				continue;
			}
			
			boolean isCombinationHabibsSubway = combination.getPrimeiroRestaurante().equals(HABIBS) && combination.getSegundoRestaurante().equals(SUBWAY);
			if(isCombinationHabibsSubway) {
				hasHabibsSubwayCombination = true;
				continue;
			}
		}
		
		assertTrue("Não encontrou a combinação "+ NOME_MC_DONALDS + " - " + NOME_SUBWAY, hasMcDonaldsSubwayCombination);
		assertTrue("Não encontrou a combinação "+ NOME_MC_DONALDS + " - " + NOME_HABIBS, hasMcDonaldsHabibsCombination);
		assertTrue("Não encontrou a combinação "+ NOME_HABIBS + " - " + NOME_SUBWAY, hasHabibsSubwayCombination);
		
	}
}
