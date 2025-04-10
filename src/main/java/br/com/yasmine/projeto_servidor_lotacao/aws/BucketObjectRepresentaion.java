package br.com.yasmine.projeto_servidor_lotacao.aws;

import lombok.Data;


public class BucketObjectRepresentaion {
	 private String objectName;
	 private String text;
	 
	 
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	 
	 
}
