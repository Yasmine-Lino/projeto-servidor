package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Lotacao implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lot_id")
	private Integer lotacaoId;
	
	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "unid_id")
	private Unidade unidade;
	
	@Column(name = "lot_data_lotacao")
	private LocalDateTime lotDataLotacao;
	
	@Column(name = "lot_data_remocao")
	private LocalDateTime lotDataRemocao;
	
	@Column(name = "lot_portaria", length = 100)
	private String lotPortaria;
	
	public Lotacao() {
		super();
	}

	public Integer getLotacaoId() {
		return lotacaoId;
	}

	public void setLotacaoId(Integer lotacaoId) {
		this.lotacaoId = lotacaoId;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public LocalDateTime getLotDataLotacao() {
		return lotDataLotacao;
	}

	public void setLotDataLotacao(LocalDateTime lotDataLotacao) {
		this.lotDataLotacao = lotDataLotacao;
	}

	public LocalDateTime getLotDataRemocao() {
		return lotDataRemocao;
	}

	public void setLotDataRemocao(LocalDateTime lotDataRemocao) {
		this.lotDataRemocao = lotDataRemocao;
	}

	public String getLotPortaria() {
		return lotPortaria;
	}

	public void setLotPortaria(String lotPortaria) {
		this.lotPortaria = lotPortaria;
	}
	
	
}
