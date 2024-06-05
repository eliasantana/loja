package com.loja.loja.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "email")
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cdEmail;
	private String assunto;
	private LocalDateTime dtEnvio;
	private LocalDateTime dtCriacao;	
	private String texto;
	private String de;
	private String para;
	
	
	public Email() {
	
	}
	
	
		
	public Email(long cdEmail, String assunto, LocalDateTime dtEnvio, LocalDateTime dtCriacao, String texto, String de,
			String para) {
		super();
		this.cdEmail = cdEmail;
		this.assunto = assunto;
		this.dtEnvio = dtEnvio;
		this.dtCriacao = dtCriacao;
		this.texto = texto;
		this.de = de;
		this.para = para;
	}



	public long getCdEmail() {
		return cdEmail;
	}
	public void setCdEmail(long cdEmail) {
		this.cdEmail = cdEmail;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public LocalDateTime getDtEnvio() {
		return dtEnvio;
	}
	public void setDtEnvio(LocalDateTime dtEnvio) {
		this.dtEnvio = dtEnvio;
	}
	public LocalDateTime getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(LocalDateTime dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}



	@Override
	public String toString() {
		return "Email [cdEmail=" + cdEmail + ", assunto=" + assunto + ", dtEnvio=" + dtEnvio + ", dtCriacao="
				+ dtCriacao + ", texto=" + texto + ", de=" + de + ", para=" + para + "]";
	}
	
	

}
