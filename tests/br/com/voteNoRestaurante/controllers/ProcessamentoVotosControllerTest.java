package br.com.voteNoRestaurante.controllers;

import static java.util.Arrays.asList;
import static org.springframework.test.web.ModelAndViewAssert.assertAndReturnModelAttributeOfType;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.servlet.ModelAndView;

import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.services.ProcessamentoService;
import br.com.voteNoRestaurante.services.ResultadoService;
import br.com.voteNoRestaurante.utils.VotoModel;
import br.com.voteNoRestaurante.utils.VotosModelWrapper;

import com.google.gson.Gson;
/**
 * Teste unitário para o controller {@link ProcessamentoVotosController}
 * 
 * @author danilo.possarle
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessamentoVotosControllerTest {

	@Mock
	private ProcessamentoService processamentoService;
	
	@Mock
	private ResultadoService resultadoService;

	@InjectMocks
	private ProcessamentoVotosController processamentoVotosController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.processamentoVotosController)
				.build();
	}

	@Test
	public void testProcessVotos() throws Exception {
		VotosModelWrapper wrapper = new VotosModelWrapper();
		wrapper.setVotosModel(asList(this.createVotoModel("McDonalds"), this.createVotoModel("Subway")));
		Gson gson = new Gson();
	    String json = gson.toJson(wrapper);
	    
	    this.mockMvc.perform(
	            post("/votos/processar")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(json))
	            .andExpect(status().isOk())
	            .andReturn();
	}

	private VotoModel createVotoModel(String restaurante) {
		VotoModel votoModel = new VotoModel();
		votoModel.setQuantidade(1);
		votoModel.setRestaurante(restaurante);
		return votoModel;
	}
	
	@Test
	public void testCreatePageCadastroUsuario() throws Exception {
		ExtendedModelMap modelMap = new ExtendedModelMap();
		ModelAndView modelAndView = this.processamentoVotosController.createPageCadastroUsuario(modelMap);
		
		assertAndReturnModelAttributeOfType(modelAndView, "usuario", Usuario.class);
		assertViewName(modelAndView, "cadastroUsuario");
	}
	
	@Test
	public void testExecutarCadastroSuccess() throws Exception {
		this.testProcessVotos();
		this.mockMvc.perform(post("/usuarios/executarCadastro").param("nome", "Teste")
								.param("email", "teste@teste.com.br"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("resultado"))
				.andExpect(model().attributeExists("rankingGeral", "rankingUsuario"));
	}
	
	@Test
	public void testExecutarCadastroErrorName() throws Exception {
		this.testProcessVotos();
		this.mockMvc.perform(post("/usuarios/executarCadastro").param("nome", "T")
								.param("email", "teste@teste.com.br"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("cadastroUsuario"))
				.andExpect(model().attributeExists("usuario"));
	}
	
	@Test
	public void testExecutarCadastroErrorEmail() throws Exception {
		this.testProcessVotos();
		this.mockMvc.perform(post("/usuarios/executarCadastro").param("nome", "Teste")
								.param("email", "teste"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("cadastroUsuario"))
				.andExpect(model().attributeExists("usuario"));
	}

}
