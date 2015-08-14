package br.com.voteNoRestaurante.controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.voteNoRestaurante.model.dao.usuario.UsuarioDAO;
import br.com.voteNoRestaurante.model.domain.Usuario;

/**
 * Controller para o cadastro do usuário e seus votos
 *  
 * @author danilo.possarle
 */
@Controller
public class CadastroController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	/**
	 * Realiza o preenchimento do model para a página de cadastro
	 * 
	 * @param model o model
	 * @return a página jsp que será exibida
	 */
	@RequestMapping("/usuarios/cadastro")
	public ModelAndView cadastro(Model model) {
		if (model.containsAttribute("usuario")) {
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
	public ModelAndView executarCadastro(@Valid Usuario usuario, BindingResult bindingResult, HttpSession sessao) {
		Model model = new ExtendedModelMap();
		model.addAttribute("usuario", usuario);
		if(bindingResult.hasErrors()){
			return this.cadastro(model);
		}
		
		this.usuarioDAO.save(usuario);
		return new ModelAndView("resultado", model.asMap());
	}
}
