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

import br.com.yasmine.projeto_servidor_lotacao.models.ServidorTemporario;
import br.com.yasmine.projeto_servidor_lotacao.repositories.ServidorTemporarioRepository;

@Controller
@RequestMapping("/servidorTemp")
public class ServidorTemporarioController {

	@Autowired
	private ServidorTemporarioRepository servidorTempRepository;
	
	@GetMapping
	public String mostraForm(ServidorTemporario servidorTemporario) {
		return "servidorTemp-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaServidorTemp() {
		ModelAndView modelAndView = new ModelAndView("listaServidorTemporario");
		List<ServidorTemporario> servidorTempLista = servidorTempRepository.findAll();
		modelAndView.addObject("servidorTempLista", servidorTempLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarServidorTemp(ServidorTemporario servidorTemporario) {
		ModelAndView modelAndView = new ModelAndView("servidorEft-cadastrar");
		servidorTempRepository.save(servidorTemporario);
		modelAndView.addObject("mensagem", "Servidor salvo com sucesso!");
		return modelAndView;
		
	}
	
	@GetMapping("/apagar/{idServidorTemp}")
	public String deletarServidorTemp(@PathVariable("idServidorTemp") Integer idServidorTemp) {
		return "redirect:/servidorTemp/lista";
	}
	
	@GetMapping("/atualizar/{idServidorTemp}")
	public String updateServidorTemp(@PathVariable Integer idServidorTemp, Model model) {
		ServidorTemporario servidorTemporario = servidorTempRepository.findById(idServidorTemp).orElse(null);
		model.addAttribute("servidorEfetivo", servidorTemporario);
		return "servidorEft-atualizar";
	}
	
	@PostMapping("/atualizar/{idServidorTemp}")
	public String atualizarServidorTemp(@PathVariable("idServidorTemp") Integer idServidorTemp, ServidorTemporario servidorTemporario, RedirectAttributes redirectAttributes) {
		servidorTemporario.setId(idServidorTemp);
		servidorTempRepository.save(servidorTemporario);
		redirectAttributes.addFlashAttribute("mensagem3", "Servidor atualizado com sucesso!");
		return "redirect:/servidorTemp/lista";
	}
	
}
