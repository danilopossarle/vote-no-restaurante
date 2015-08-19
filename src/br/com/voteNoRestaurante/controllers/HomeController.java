package br.com.voteNoRestaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.voteNoRestaurante.services.HomeService;

/**
 * Controller inicial da aplicação
 * 
 * @author danilo.possarle
 */
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	/**
	 * Realiza o preenchimento do model para a página inicial
	 * 
	 * @param model o model a ser preenchido
	 * @return {@link ModelAndView} com a página a ser direcionada e o model preenchido
	 */
	@RequestMapping("/")
	public ModelAndView index(Model model) {
		model.addAttribute("combinacoesVotos", this.homeService.generateCombinations());
		return new ModelAndView("index", model.asMap());
	}
}
