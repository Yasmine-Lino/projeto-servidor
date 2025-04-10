package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;
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
import jakarta.persistence.OneToMany;

@Entity
public class Unidade implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unid_id")
	private Integer unidId;
	
	@Column(name = "unid_nome", length = 200)
	private String unidNome;
	
	@Column(name = "unid_sigla", length = 20)
	private String unidSigla;
	
	public Unidade() {
		super();
	}

	public Integer getUnidId() {
		return unidId;
	}

	public void setUnidId(Integer unidId) {
		this.unidId = unidId;
	}

	public String getUnidNome() {
		return unidNome;
	}

	public void setUnidNome(String unidNome) {
		this.unidNome = unidNome;
	}

	public String getUnidSigla() {
		return unidSigla;
	}

	public void setUnidSigla(String unidSigla) {
		this.unidSigla = unidSigla;
	}
	
	
}
