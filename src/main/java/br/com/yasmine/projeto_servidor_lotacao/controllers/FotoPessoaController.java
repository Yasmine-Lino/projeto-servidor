package br.com.yasmine.projeto_servidor_lotacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yasmine.projeto_servidor_lotacao.aws.FileService;
import br.com.yasmine.projeto_servidor_lotacao.models.FotoPessoa;
import br.com.yasmine.projeto_servidor_lotacao.models.Pessoa;
import br.com.yasmine.projeto_servidor_lotacao.repositories.FotoPessoaRepository;
import br.com.yasmine.projeto_servidor_lotacao.repositories.PessoaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/foto")
public class FotoPessoaController {

	@Autowired
	private FotoPessoaRepository ftPRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping
	public String mostraForm(FotoPessoa fotoPessoa, Model model) {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		model.addAttribute("pessoas", pessoas);
		return "ftPessoa-lista";
	}
	
	@GetMapping("/lista")
	public ModelAndView listaFoto() {
		ModelAndView modelAndView = new ModelAndView("listaFoto");
		List<FotoPessoa> ftPessoaLista = ftPRepository.findAll();
		modelAndView.addObject("ftPessoaLista", ftPessoaLista);
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView cadastrarFoto(@Valid @ModelAttribute("foto")FotoPessoa fotoPessoa, @RequestParam("file") MultipartFile file) {
		ModelAndView modelAndView = new ModelAndView("foto-cadastrar");
		String profileImageUrl = fileService.uploadFile(file, fotoPessoa.getFotoBucket(), "fileImage=");
		fotoPessoa.setFotoHash(profileImageUrl);
		ftPRepository.save(fotoPessoa);
		modelAndView.addObject("mensagem", "Foto salva com sucesso!");
		return modelAndView;
	}
	
	@GetMapping("/apagar/{idftPessoa}")
	public String deletarFoto(@PathVariable("idftPessoa") Integer idftPessoa) {
		ftPRepository.deleteById(idftPessoa);
		return "redirect:/foto/lista";
	}
	
	@GetMapping("/atualizar/{idftPessoa}")
	public String editarFoto(@PathVariable Integer idftPessoa, Model model) {
		FotoPessoa fotoPessoa = ftPRepository.findById(idftPessoa).orElse(null);
		model.addAttribute("fotoPessoa", fotoPessoa);
		List<Pessoa> pessoas = pessoaRepository.findAll();
		model.addAttribute("pessoas", pessoas);
		return "foto-atualizar";
	}
	
	@PostMapping("/atualizar/{idftPessoa}")
	public String atualizarFoto(@PathVariable("idftPessoa") Integer idftPessoa, FotoPessoa fotoPessoa, RedirectAttributes redirectAttributes) {
		fotoPessoa.setFotoId(idftPessoa);
		ftPRepository.save(fotoPessoa);
		redirectAttributes.addFlashAttribute("mensagem3", "Foto atualizada com sucesso!");
		return "redirect:/foto/lista";
	}
	
	
}
