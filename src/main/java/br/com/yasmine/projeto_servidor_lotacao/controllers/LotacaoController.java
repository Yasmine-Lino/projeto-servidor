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

import br.com.yasmine.projeto_servidor_lotacao.models.Lotacao;
import br.com.yasmine.projeto_servidor_lotacao.repositories.LotacaoRepository;

@Controller
@RequestMapping("/lotacao")
public class LotacaoController {

	@Autowired
	private LotacaoRepository lotacaoRepository;
	
	@GetMapping
	public String mostraForm(Lotacao lotacao){
		return "lotacao-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaLotacao() {
		ModelAndView modelAndView = new ModelAndView("listaLotacao");
		List<Lotacao> lotacaoLista = lotacaoRepository.findAll();
		modelAndView.addObject("lotacaoLista", lotacaoLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarLotacao(Lotacao lotacao) {
		ModelAndView modelAndView = new ModelAndView("lotacao-cadastrar");
		lotacaoRepository.save(lotacao);
		modelAndView.addObject("mensagem", "Lotação salva com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idLotacao}")
	public String deletarLotacao(@PathVariable("idLotacao") Integer idLotacao) {
		return "redirect:/lotacao/lista";
	}
	
	@GetMapping("/atualizar/{idLotacao}")
	public String updateLotacao(@PathVariable Integer idLotacao, Model model) {
		Lotacao lotacao = lotacaoRepository.findById(idLotacao).orElse(null);
		model.addAttribute("lotacao", lotacao);
		return "lotacao-atualizar";
	}
	
	@PostMapping("/atualizar/{idLotacao}")
	public String atualizarLotacao(@PathVariable("idLotacao") Integer idLotacao, Lotacao lotacao, RedirectAttributes redirectAttributes) {
		lotacao.setLotacaoId(idLotacao);
		lotacaoRepository.save(lotacao);
		redirectAttributes.addFlashAttribute("mensagem3", "Lotação atualizada com sucesso!");
		return "redirect:/lotacao/lista";
	}
}
