package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_id")
	private Integer enderecoId;
	
	@Column(name = "end_tipo_logradouro", length = 50)
	private String enderecoTpLogradouro;
	
	@Column(name = "end_logradouro", length = 200)
	private String enderecoLogradouro;
	
	@Column(name = "end_numero")
	private Integer enderecoNumero;
	
	@Column(name = "end_bairro", length = 100)
	private String enderecoBairro;
	
	@ManyToOne
	@JoinColumn(name = "cid_id")
	private Cidade cidade;
	
	@ManyToMany
	@JoinTable(name = "unidade_endereco" ,joinColumns = {@JoinColumn( name = "unid_id")},
		inverseJoinColumns = {@JoinColumn(name = "end_id")})
	private List<Unidade> unidade;
	
	public Endereco() {
		super();
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getEnderecoTpLogradouro() {
		return enderecoTpLogradouro;
	}

	public void setEnderecoTpLogradouro(String enderecoTpLogradouro) {
		this.enderecoTpLogradouro = enderecoTpLogradouro;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public Integer getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Unidade> getUnidade() {
		return unidade;
	}

	public void setUnidade(List<Unidade> unidade) {
		this.unidade = unidade;
	}
	
	
	
}
