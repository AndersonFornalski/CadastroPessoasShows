package com.CadastroPessoasEventosSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CadastroPessoasEventosSpring.model.Pessoas;
import com.CadastroPessoasEventosSpring.repositories.PessoasRepository;

@Service
public class PessoasServices {
	
	@Autowired
	private PessoasRepository pessoasRepository;
	
	public List<Pessoas> findAll(){
		return pessoasRepository.findAll();
	}
	
	public Pessoas findOne(Long id) {
		return pessoasRepository.getOne(id);		
	}
	
	public Pessoas save(Pessoas post) {
		return pessoasRepository.saveAndFlush(post);
	}
	
	public void delete(Long id) {
		pessoasRepository.deleteById(id);
	}
	
	
	
	
}


