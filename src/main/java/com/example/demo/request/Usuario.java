package com.example.demo.request;

import java.io.Serializable;
import java.text.Annotation;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "data")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5639281985484861320L;
	
	private String nome;
	private String senha;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario(String nome, String senha, String cpf) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
