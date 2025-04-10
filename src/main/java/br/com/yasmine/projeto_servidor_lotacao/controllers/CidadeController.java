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

import br.com.yasmine.projeto_servidor_lotacao.models.Cidade;
import br.com.yasmine.projeto_servidor_lotacao.repositories.CidadeRepository;

@Controller
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidRepository;
	
	@GetMapping
	public String mostraForm(Cidade cidade) {
		return "cid-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaCidade() {
		ModelAndView modelAndView = new ModelAndView("listaCidade");
		List<Cidade> cidLista = cidRepository.findAll();
		modelAndView.addObject("cidLista", cidLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarCidade(Cidade cidade) {
		ModelAndView modelAndView = new ModelAndView("cid-cadastrar");
		cidRepository.save(cidade);
		modelAndView.addObject("mensagem", "Cidade salva com sucesso!");
		return modelAndView;
	}

	@GetMapping("/apagar/{idCidade}")
	public String deletarCidade(@PathVariable("idCidade") Integer idCidade) {
		return "redirect:/cidade/lista";
	}
	
	@GetMapping("/atualizar/{idCidade}")
	public String updateCidade(@PathVariable Integer idCidade, Model model) {
		Cidade cidade = cidRepository.findById(idCidade).orElse(null);
		model.addAttribute("cidade", cidade);
		return "cidade-atualizar";
	}
	
	@PostMapping("/atualizar/{idCidade}")
	public String atualizarCidade(@PathVariable("idCidade") Integer idCidade, Cidade cidade, RedirectAttributes redirectAttributes) {
		cidade.setCidadeId(idCidade);
		cidRepository.save(cidade);
		redirectAttributes.addFlashAttribute("mensagem3", "Cidade atualizada com sucesso!");
		return "redirect:/cidade/lista";
	}
	
}
