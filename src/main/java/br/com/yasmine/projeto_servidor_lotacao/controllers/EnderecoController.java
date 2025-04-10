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

import br.com.yasmine.projeto_servidor_lotacao.models.Endereco;
import br.com.yasmine.projeto_servidor_lotacao.repositories.EnderecoRepository;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository endRepository;
	
	@GetMapping
	public String mostraForm(Endereco endereco) {
		return "end-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaEndereco() {
		ModelAndView modelAndView = new ModelAndView("listaEnd");
		List<Endereco> endLista = endRepository.findAll();
		modelAndView.addObject("endLista", endLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarEndereco(Endereco endereco) {
		ModelAndView modelAndView = new ModelAndView("end-cadastrar");
		endRepository.save(endereco);
		modelAndView.addObject("mensagem", "Endereço salvo com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idEndereco}")
	public String deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) {
		return "redirect:/endereco/lista";
	}
	
	@GetMapping("/atualizar/{idEndereco}")
	public String updateEndereco(@PathVariable Integer idEndereco, Model model) {
		Endereco endereco = endRepository.findById(idEndereco).orElse(null);
		model.addAttribute("cidade", endereco);
		return "endereco-atualizar";
	}
	
	@PostMapping("/atualizar/{idEndereco}")
	public String atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco, Endereco endereco, RedirectAttributes redirectAttributes) {
		endereco.setEnderecoId(idEndereco);
		endRepository.save(endereco);
		redirectAttributes.addFlashAttribute("mensagem3", "Endereço atualizado com sucesso!");
		return "redirect:/endereco/lista";
	}
}
