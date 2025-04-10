package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pes_id")
	private Integer pessoaId;
	
	@Column(name = "pes_nome", length = 200)
	private String pessoaNome;
	
	@Column(name = "pes_data_nascimento")
	private LocalDateTime dataNasc;
	
	@Column(name = "pes_sexo", length = 9)
	private String pessoaSexo;
	
	@Column(name = "pes_mae", length = 200)
	private String pessoaMae;
	
	@Column(name = "pes_pai", length = 200)
	private String pessoaPai;
	
	@ManyToMany
	@JoinTable(name = "pessoa_endereco" ,joinColumns = {@JoinColumn( name = "pes_id")},
		inverseJoinColumns = {@JoinColumn(name = "end_id")})
	private List<Endereco> endereco;
	
	public Pessoa() {
		super();
	}
	
	public Integer getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}
	public String getPessoaNome() {
		return pessoaNome;
	}
	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}
	public LocalDateTime getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getPessoaSexo() {
		return pessoaSexo;
	}
	public void setPessoaSexo(String pessoaSexo) {
		this.pessoaSexo = pessoaSexo;
	}
	public String getPessoaMae() {
		return pessoaMae;
	}
	public void setPessoaMae(String pessoaMae) {
		this.pessoaMae = pessoaMae;
	}
	public String getPessoaPai() {
		return pessoaPai;
	}
	public void setPessoaPai(String pessoaPai) {
		this.pessoaPai = pessoaPai;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	
}
