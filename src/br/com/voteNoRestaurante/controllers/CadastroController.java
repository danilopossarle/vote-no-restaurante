package br.com.voteNoRestaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.voteNoRestaurante.model.domain.Usuario;
import br.com.voteNoRestaurante.utils.VotosModelWraper;
import br.com.voteNoRestaurante.utils.services.CadastroService;

/**
 * Controller para o cadastro do usuário e seus votos
 *  
 * @author danilo.possarle
 */
@Controller
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;
	
	/**
	 * Realiza o preenchimento do model para a página de cadastro
	 * 
	 * @param model o model
	 * @return a página jsp que será exibida
	 */
	@RequestMapping(value="/usuarios/cadastro", method = RequestMethod.POST)
	@Transactional
	public ModelAndView cadastro(@RequestBody VotosModelWraper votosModelWraper) {
		Model model = new ExtendedModelMap();
		model.addAttribute("votos", this.cadastroService.processVotos(votosModelWraper));
		model.addAttribute("usuario", new Usuario());
		return new ModelAndView("cadastroUsuario", model.asMap());
	}
	
}
