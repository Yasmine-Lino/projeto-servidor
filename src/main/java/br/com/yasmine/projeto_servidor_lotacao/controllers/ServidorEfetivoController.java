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

import br.com.yasmine.projeto_servidor_lotacao.models.ServidorEfetivo;
import br.com.yasmine.projeto_servidor_lotacao.repositories.ServidorEfetivoRepository;

@Controller
@RequestMapping("/servidorEft")
public class ServidorEfetivoController {

	@Autowired
	private ServidorEfetivoRepository servidorEftRepository;
	
	@GetMapping
	public String mostraForm(ServidorEfetivo servidorEfetivo) {
		return "servidorEft-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaServidorEft() {
		ModelAndView modelAndView = new ModelAndView("listaServidorEfetivo");
		List<ServidorEfetivo> servidorEftLista = servidorEftRepository.findAll();
		modelAndView.addObject("servidorEftLista", servidorEftLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarServidorEft(ServidorEfetivo servidorEfetivo) {
		ModelAndView modelAndView = new ModelAndView("servidorEft-cadastrar");
		servidorEftRepository.save(servidorEfetivo);
		modelAndView.addObject("mensagem", "Servidor salvo com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idServidorEft}")
	public String deletarServidorEft(@PathVariable("idServidorEft") Integer idServidorEft) {
		return "redirect:/servidorEft/lista";
	}
	
	@GetMapping("/atualizar/{idServidorEft}")
	public String updateServidorEft(@PathVariable Integer idServidorEft, Model model) {
		ServidorEfetivo servidorEfetivo = servidorEftRepository.findById(idServidorEft).orElse(null);
		model.addAttribute("servidorEfetivo", servidorEfetivo);
		return "servidorEft-atualizar";
	}
	
	@PostMapping("/atualizar/{idServidorEft}")
	public String atualizarServidorEft(@PathVariable("idServidorEft") Integer idServidorEft, ServidorEfetivo servidorEfetivo, RedirectAttributes redirectAttributes) {
		servidorEfetivo.setId(idServidorEft);
		servidorEftRepository.save(servidorEfetivo);
		redirectAttributes.addFlashAttribute("mensagem3", "Servidor atualizado com sucesso!");
		return "redirect:/servidorEft/lista";
	}
	
}
