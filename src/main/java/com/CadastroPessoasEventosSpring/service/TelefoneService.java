package com.CadastroPessoasEventosSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CadastroPessoasEventosSpring.model.TelefonePessoas;
import com.CadastroPessoasEventosSpring.repositories.TelefonesRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefonesRepository telefoneRepository;	

	public List<TelefonePessoas> findAll() { 
		return telefoneRepository.findAll();
	}

	public TelefonePessoas findOne(Long id) {
		return telefoneRepository.getOne(id);
	}

	public TelefonePessoas save(TelefonePessoas post) {
		return telefoneRepository.saveAndFlush(post);
	}

	public void delete(Long id) {
		telefoneRepository.deleteById(id);
	}
}
