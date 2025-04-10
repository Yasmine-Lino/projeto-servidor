package br.com.yasmine.projeto_servidor_lotacao.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


public class PessoaEndereco {
	
	@OneToMany(mappedBy = "pessoa")
	private List<Pessoa> pessoa;
	
	@OneToMany(mappedBy = "endereco")
	private List<Endereco> endereco;

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

}
