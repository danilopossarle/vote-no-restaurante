package br.com.voteNoRestaurante.services;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.voteNoRestaurante.model.dao.restaurante.RestauranteDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;

/**
 * Teste para {@link ResultadoService}
 * 
 * @author danilo.possarle
 */
public class ResultadoServiceTest {
	
	@Mock
	private RestauranteDAO restauranteDAO;

	@InjectMocks
	private ResultadoService resultadoService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetRankingGeral() {
		this.resultadoService.getRankingGeral();
		verify(this.restauranteDAO, Mockito.only()).getRankingGeral();
	}
	
	@Test
	public void testGetRankingUsuario() {
		Usuario usuario = new Usuario();
		this.resultadoService.getRankingUsuario(usuario);
		verify(this.restauranteDAO, Mockito.only()).getRankingUsuario(usuario);
	}
}
