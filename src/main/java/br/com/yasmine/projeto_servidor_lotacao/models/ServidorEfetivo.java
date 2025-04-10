package br.com.yasmine.projeto_servidor_lotacao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServidorEfetivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;
	
	@Column(name = "se_matricula", length = 20)
	private String servidorEfMatricula;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getServidorEfMatricula() {
		return servidorEfMatricula;
	}

	public void setServidorEfMatricula(String servidorEfMatricula) {
		servidorEfMatricula = servidorEfMatricula;
	}

	
}
