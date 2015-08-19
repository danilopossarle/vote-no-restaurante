package br.com.voteNoRestaurante.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.model.domain.Voto;
import br.com.voteNoRestaurante.utils.VotosModelWrapper;
import br.com.voteNoRestaurante.utils.services.CadastroService;
import br.com.voteNoRestaurante.utils.services.ResultadoService;

/**
 * Controller para o cadastro do usuário e seus votos
 * 
 * @author danilo.possarle
 */
@Controller
@SessionAttributes("votos")
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;
	
	@Autowired
	private ResultadoService resultadoService;

	private List<Voto> votos;

	/**
	 * Realiza o processamento dos votos
	 * 
	 * @param votosModelWraper {@link VotosModelWrapper}
	 * @return o status do processamento (1 sucesso, 0 falha)
	 */
	@RequestMapping(value = "/votos/processar", method = RequestMethod.POST)
	public @ResponseBody int processVotos(@RequestBody VotosModelWrapper votosModelWraper) {
		this.votos = this.cadastroService.processVotos(votosModelWraper);
		return this.votos.isEmpty() ? 0 : 1;
	}

	/**
	 * Redireciona para a página de cadastro
	 * 
	 * @param model {@link Model} da página
	 * @return {@linkplain ModelAndView} para a página de cadastro
	 */
	@RequestMapping(value = "/usuarios/cadastro")
	public ModelAndView createPageCadastroUsuario(Model model) {
		if (!model.containsAttribute("usuario")) {
			model.addAttribute("usuario", new Usuario());
		}
		return new ModelAndView("cadastroUsuario", model.asMap());
	}

	/**
	 * Realiza o cadastro do usuário com suas preferências
	 *
	 * @param usuario {@link Usuario} que está votando
	 * @param bindingResult {@link BindingResult} para realizar a validação dos dados
	 * @param sessao {@link HttpSession}
	 * @return a página jsp para qual o usuário deverá ser redirecionado
	 */
	@RequestMapping(value = "/usuarios/executarCadastro", method = RequestMethod.POST)
	@Transactional
	public ModelAndView executarCadastro(@Valid Usuario usuario, BindingResult bindingResult, HttpSession sessao) {
		Model model = new ExtendedModelMap();

		if (bindingResult.hasErrors()) {
			model.addAttribute("usuario", usuario);
			return this.createPageCadastroUsuario(model);
		} else {
			this.cadastroService.save(usuario);
			for (Voto voto : this.votos) {
				voto.setUsuario(usuario);
				this.cadastroService.save(voto);
			}
		}

		model.addAttribute("rankingGeral", this.resultadoService.getRankingGeral());
		model.addAttribute("rankingUsuario", this.resultadoService.getRankingUsuario(usuario));

		return new ModelAndView("resultado", model.asMap());
	}

}
