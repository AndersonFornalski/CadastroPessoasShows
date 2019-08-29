package com.CadastroPessoasEventosSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CadastroPessoasEventosSpring.model.Pessoas;
import com.CadastroPessoasEventosSpring.model.TelefonePessoas;
import com.CadastroPessoasEventosSpring.repositories.TelefonesRepository;
import com.CadastroPessoasEventosSpring.service.PessoasServices;
import com.CadastroPessoasEventosSpring.service.TelefoneService;

@Controller
public class TelefonesPessoasController {
		
	@Autowired
	TelefonesRepository foneRepository;
	
	@Autowired
	TelefoneService foneService;
	
	@Autowired
	PessoasServices pessoaService;
	
	
/*MÉTODO DETALHES PELO ID*/
	@GetMapping(value = "/detalhePessoa/{iddetalhe}")
	public ModelAndView Detalhes(@PathVariable("iddetalhe") Long id ) {
		ModelAndView mv = new ModelAndView("pessoas/telefonePessoas");
		mv.addObject("listaFones", foneRepository.getTelefones(id));//trocar(idFonePessoa) por (id) conforme acima
		mv.addObject("pessoasObj", pessoaService.findOne(id));
		
		
		return mv;
	}	
	
	
/*MÉTODO SALVAR TELEFONE pelo pessoaObj na tela html("telefonePessoas.html")*/	
	@PostMapping(value = "**/addFonePessoa/{idFonePessoa}")
	public ModelAndView AddFoneConvidado(TelefonePessoas telefonePessoas, @PathVariable("idFonePessoa") Long idFonePessoa ) {

		Pessoas pessoas = pessoaService.findOne(idFonePessoa);//essas 2 linhas,necessario para amarrar ID do Objeto Pessoa com telefone
		telefonePessoas.setPessoas(pessoas);
		
		foneService.save(telefonePessoas);		
		ModelAndView mv = new ModelAndView("pessoas/telefonePessoas");	
		mv.addObject("pessoasObj", pessoaService.findOne(idFonePessoa));
		mv.addObject("listaFones", foneRepository.getTelefones(idFonePessoa));//precisa fazer a Query no TelefoneRepository
		return mv;
	}
	 
	
	//ESTE MÉTODO ABAIXO TAMBEM PODE SER USADO POREM IMPORTANDO O PessoaRepository no @Autowired e não o Service Criado.
	
	/*	Pessoas pessoas = pessoaRepository.findById(idFonePessoa).get();---esses linha para encontrar o id
		telefonePessoas.setPessoas(pessoas);----esta linha para setar no banco de dados o id
		foneService.save(telefonePessoas);
		ModelAndView mv = new ModelAndView("pessoas/telefonePessoas");
		mv.addObject("pessoasObj", pessoaService.findOne(idFonePessoa));
	
	return mv;
	
	}*/
	
	
//MÉTODO LISTAR TODOS TELEFONES DO BANCO
	/*@GetMapping(value = "/listarTelefones")
	public ModelAndView ListarFones() {		
		ModelAndView mv = new ModelAndView("pessoas/telefonesPessoas");
		mv.addObject("listaFones", foneService.findAll());
		
		return mv;
		
	}*/
	
	
}



















