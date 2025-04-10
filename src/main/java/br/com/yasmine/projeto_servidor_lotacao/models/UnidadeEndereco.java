package br.com.yasmine.projeto_servidor_lotacao.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

public class UnidadeEndereco {

	@OneToMany(mappedBy = "unidade")
	private List<Unidade> unidade;
	
	@OneToMany(mappedBy = "endereco")
	private List<Endereco> endereco;

	public List<Unidade> getUnidade() {
		return unidade;
	}

	public void setUnidade(List<Unidade> unidade) {
		this.unidade = unidade;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
}
