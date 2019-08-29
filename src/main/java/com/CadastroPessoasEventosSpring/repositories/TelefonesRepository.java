package com.CadastroPessoasEventosSpring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CadastroPessoasEventosSpring.model.TelefonePessoas;

public interface TelefonesRepository extends JpaRepository<TelefonePessoas, Long >{

//Essa Query é para fazer a listagem dos telefones de cada convidado separado por ID.
//Precisa importar o repository no TelefoneController.	
	@Query("select t from TelefonePessoas t where t.pessoas.id = ?1")// pessoas é onde está no @ManyToOne do objeto TelefonePessoas
	public List<TelefonePessoas> getTelefones(Long idFonePessoa);
}
