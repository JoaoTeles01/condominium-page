package com.example.teste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.teste.entity.Inquilino;
import com.example.teste.entity.VeiculosInqui;
import com.example.teste.repository.InquilinoRepository;
import com.example.teste.repository.VeiculosInquiRepository;

@Component
@Controller
public class CondominioController {
	
	@Autowired
	private InquilinoRepository repo;
	@Autowired
	private VeiculosInquiRepository repoVei;

	private static CondominioController instance;
	
	public static CondominioController getInstance() {
		if(instance == null) {
			instance = new CondominioController();
		}
		return instance;
	}
	
	@GetMapping("home")
	public ModelAndView home(ModelMap model) {
		return new ModelAndView("programa/home", model);
	}
	
	@GetMapping("listagem")
	public ModelAndView listagem(ModelMap model) {
		List<Inquilino> lista = repo.findAll();
		model.addAttribute("lista", lista);
		return new ModelAndView("programa/listaInquilinos");
	}
	
	@GetMapping("cadastroInquilino")
	public ModelAndView cadastroInquilino(ModelMap model) {
		Inquilino inqui = new Inquilino();
		model.addAttribute("inqui", inqui);
		return new ModelAndView("programa/cadastroNovoInquilino");
	}
	
	@PostMapping("cadastroSalvar")
	public ModelAndView cadastroSalvar (@ModelAttribute("inqui") Inquilino inqui, ModelMap model) {
		repo.save(inqui);
		model.addAttribute("id", inqui.getCpf());
		return new ModelAndView("redirect:detalharInquilino", model);
	}
	
	@GetMapping("detalharInquilino")
	public ModelAndView detalharInquilino(@ModelAttribute("id") String cpf, ModelMap model) {
		Inquilino inqui = repo.findById(cpf).get();
		model.addAttribute("inqui", inqui);
		return new ModelAndView("programa/detalharInquilino", model);

	}
	
	@GetMapping("loginInqui")
	public ModelAndView loginInqui(ModelMap model) {
		CondominioController.getInstance();
		model.addAttribute("loginInqui", new Inquilino());
		return new ModelAndView("programa/loginInqui");
	}
	
	@PostMapping("enviar")
	public ModelAndView enviar(@RequestParam("cpf")List<String> cpf, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("cpf", cpf);
		return new ModelAndView("redirect:outroMetodo");
	}
	
	
	@GetMapping("outroMetodo")
	public ModelAndView outroMetodo(@ModelAttribute("cpf") List<String> cpf, ModelMap model) {
	    for (String id : cpf) {
	    	Optional<Inquilino> inqui =  repo.findById(id);
	    	inqui.get().setNome(inqui.get().getNome());
	    	
	    	model.addAttribute("id", id);
	    }
	    return new ModelAndView("redirect:outraPagina", model);
	}
	
	@GetMapping("cadastroVei")
	public ModelAndView cadastroVei(@ModelAttribute("placa")VeiculosInqui idVeiculos, ModelMap model) {
		VeiculosInqui vei = new VeiculosInqui();
		model.addAttribute("vei", vei);
		return new ModelAndView("programa/cadastroNovoVeiculo");
	}
	
	@PostMapping("cadastroVeiSalvar")
	public ModelAndView cadastroVeiSalvar (@ModelAttribute("placa") VeiculosInqui idVeiculos, ModelMap model) {
		repoVei.save(idVeiculos);
		model.addAttribute("id", idVeiculos.getPlaca());
		return new ModelAndView("redirect:detalharInquilino", model);
	}

}
