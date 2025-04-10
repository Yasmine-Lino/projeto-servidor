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

import br.com.yasmine.projeto_servidor_lotacao.models.Pessoa;
import br.com.yasmine.projeto_servidor_lotacao.repositories.PessoaRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public String mostraForm(Pessoa pessoa){
		return "pessoa-cadastrar";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaPessoa() {
		ModelAndView modelAndView = new ModelAndView("listaPessoa");
		List<Pessoa> pessoaLista = pessoaRepository.findAll();
		modelAndView.addObject("pessoaLista", pessoaLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarPessoa(Pessoa pessoa) {
		ModelAndView modelAndView = new ModelAndView("pessoa-cadastrar");
		pessoaRepository.save(pessoa);
		modelAndView.addObject("mensagem", "Pessoa salva com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idPessoa}")
	public String deletarPessoa(@PathVariable("idPessoa") Integer idPessoa) {
		return "redirect:/pessoa/lista";
	}
	
	@GetMapping("/atualizar/{idPessoa}")
	public String updatePessoa(@PathVariable Integer idPessoa, Model model) {
		Pessoa pessoa = pessoaRepository.findById(idPessoa).orElse(null);
		model.addAttribute("pessoa", pessoa);
		return "pessoa-atualizar";
	}
	
	@PostMapping("/atualizar/{idPessoa}")
	public String atualizarPessoa(@PathVariable("idPessoa") Integer idPessoa, Pessoa pessoa, RedirectAttributes redirectAttributes) {
		pessoa.setPessoaId(idPessoa);
		pessoaRepository.save(pessoa);
		redirectAttributes.addFlashAttribute("mensagem3", "Pessoa atualizada com sucesso!");
		return "redirect:/pessoa/lista";
	}
}
