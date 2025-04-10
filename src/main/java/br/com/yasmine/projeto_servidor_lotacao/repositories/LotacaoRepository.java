package br.com.yasmine.projeto_servidor_lotacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yasmine.projeto_servidor_lotacao.models.Lotacao;

public interface LotacaoRepository extends JpaRepository<Lotacao, Integer>{

}
