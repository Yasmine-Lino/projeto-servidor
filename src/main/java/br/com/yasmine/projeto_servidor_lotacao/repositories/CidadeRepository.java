package br.com.yasmine.projeto_servidor_lotacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasmine.projeto_servidor_lotacao.models.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
