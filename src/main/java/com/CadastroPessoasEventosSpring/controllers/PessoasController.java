package com.CadastroPessoasEventosSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CadastroPessoasEventosSpring.model.Pessoas;
import com.CadastroPessoasEventosSpring.service.PessoasServices;

@Controller
public class PessoasController{
	
	@Autowired
	PessoasServices pessoaService;
	
	
	
	@GetMapping(value = "/cadastroPessoas")
	public ModelAndView inicio(){		
		
		ModelAndView mv = new ModelAndView("pessoas/cadastroPessoas");	
		mv.addObject("pessoasObj", new Pessoas());
		mv.addObject("lista", pessoaService.findAll());
		
		
		return mv;
	}	
	
/*MÉTODO SALVAR*/	
	@PostMapping(value = "**/salvarPessoa") 
	public ModelAndView salvar(Pessoas pessoas){
		ModelAndView mv = new ModelAndView("pessoas/cadastroPessoas");		
		pessoaService.save(pessoas);
		mv.addObject("lista", pessoaService.findAll());		
		mv.addObject("pessoasObj", new Pessoas());
		
		
		return mv;
		
	}

/*MÉTODO LISTAR*/	
	@GetMapping(value = "/listarConvidados")
	public ModelAndView listarPessoas() {
		ModelAndView mv = new ModelAndView("pessoas/cadastroPessoas");
		mv.addObject("lista", pessoaService.findAll());
		
		
		return mv;
	}
/*MÉTODO EDITAR PELO ID*/
	@GetMapping(value = "/editarpessoa/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {	
		
        ModelAndView mv = new ModelAndView("pessoas/cadastroPessoas");
		mv.addObject("pessoasObj", pessoaService.findOne(id));
		
		return mv;
		
	}
	
/*MÉTODO DELETAR PELO ID*/
	@GetMapping(value = "/deletarpessoa/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id) {
		pessoaService.delete(id);			
		ModelAndView mv = new ModelAndView("pessoas/cadastroPessoas");
		mv.addObject(pessoaService.findAll());
		mv.addObject("pessoasObj", new Pessoas());/*Objeto Vazio*/
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






















