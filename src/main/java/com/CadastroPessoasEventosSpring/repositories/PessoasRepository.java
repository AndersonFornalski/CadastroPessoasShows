package com.CadastroPessoasEventosSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CadastroPessoasEventosSpring.model.Pessoas;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {

}
