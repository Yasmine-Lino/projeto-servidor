package br.com.yasmine.projeto_servidor_lotacao.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServidorTemporario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;
	
	@Column(name = "st_data_admissao")
	private LocalDateTime servidorDtAdmissao;
	
	@Column(name = "st_data_demissao")
	private LocalDateTime servidorDtDemissao;
	
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

	public LocalDateTime getServidorDtAdmissao() {
		return servidorDtAdmissao;
	}

	public void setServidorDtAdmissao(LocalDateTime servidorDtAdmissao) {
		this.servidorDtAdmissao = servidorDtAdmissao;
	}

	public LocalDateTime getServidorDtDemissao() {
		return servidorDtDemissao;
	}

	public void setServidorDtDemissao(LocalDateTime servidorDtDemissao) {
		this.servidorDtDemissao = servidorDtDemissao;
	}
	
	

}
