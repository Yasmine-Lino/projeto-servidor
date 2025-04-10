package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cidade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
	private Integer cidadeId;
	
	@Column(name = "cid_nome", length = 200)
	private String cidadeNome;
	
	@Column(name = "cid_uf", length = 2)
	private String cidadeUf;
	
	public Cidade() {
		super();
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getCidadeNome() {
		return cidadeNome;
	}

	public void setCidadeNome(String cidadeNome) {
		this.cidadeNome = cidadeNome;
	}

	public String getCidadeUf() {
		return cidadeUf;
	}

	public void setCidadeUf(String cidadeUf) {
		this.cidadeUf = cidadeUf;
	}
	
	
}
