package br.com.yasmine.projeto_servidor_lotacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasmine.projeto_servidor_lotacao.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
