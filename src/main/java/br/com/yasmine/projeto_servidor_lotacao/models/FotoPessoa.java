package br.com.yasmine.projeto_servidor_lotacao.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FotoPessoa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fp_id")
	private Integer fotoId;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;
	
	@Column(name = "fp_data")
	private LocalDateTime fotoData;
	
	@Column(name = "fp_bucket", length = 50)
	private String fotoBucket;
	
	@Column(name = "fp_hash", length = 50)
	private String fotoHash;
	
	public FotoPessoa() {
		super();
	}

	public Integer getFotoId() {
		return fotoId;
	}

	public void setFotoId(Integer fotoId) {
		this.fotoId = fotoId;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDateTime getFotoData() {
		return fotoData;
	}

	public void setFotoData(LocalDateTime fotoData) {
		this.fotoData = fotoData;
	}

	public String getFotoBucket() {
		return fotoBucket;
	}

	public void setFotoBucket(String fotoBucket) {
		this.fotoBucket = fotoBucket;
	}

	public String getFotoHash() {
		return fotoHash;
	}

	public void setFotoHash(String fotoHash) {
		this.fotoHash = fotoHash;
	}
	
	
}
