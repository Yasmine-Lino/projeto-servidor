package br.com.yasmine.projeto_servidor_lotacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yasmine.projeto_servidor_lotacao.models.Unidade;
import br.com.yasmine.projeto_servidor_lotacao.repositories.UnidadeRepository;

@Controller
@RequestMapping("/unidade")
public class UnidadeController {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@GetMapping
	public String mostraForm(Unidade unidade) {
		return "unidade-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaUnidade() {
		ModelAndView modelAndView = new ModelAndView("listaUnidade");
		List<Unidade> unidadeLista = unidadeRepository.findAll();
		modelAndView.addObject("unidadeLista", unidadeLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarUnidade(Unidade unidade) {
		ModelAndView modelAndView = new ModelAndView("unidade-cadastrar");
		unidadeRepository.save(unidade);
		modelAndView.addObject("mensagem", "Unidade salva com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idUnidade}")
	public String deletarUnidade(@PathVariable("idUnidade") Integer idUnidade) {
		return "redirect:/unidade/lista";
	}
	
	@GetMapping("/atualizar/{idUnidade}")
	public String updateUnidade(@PathVariable Integer idUnidade, Model model) {
		Unidade unidade = unidadeRepository.findById(idUnidade).orElse(null);
		model.addAttribute("unidade", unidade);
		return "unidade-atualizar";
	}
	
	@PostMapping("/atualizar/{idUnidade}")
	public String atualizarUnidade(@PathVariable("idUnidade") Integer idUnidade, Unidade unidade, RedirectAttributes redirectAttributes) {
		unidade.setUnidId(idUnidade);
		unidadeRepository.save(unidade);
		redirectAttributes.addFlashAttribute("mensagem3", "Unidade atualizada com sucesso!");
		return "redirect:/unidade/lista";
	}

}
