package com.example.teste.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name = "inqui_cond", schema = "public")
public class Inquilino {
	
	@Id
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tipo_inquilino")
	private String tipoInquilino;
	
	@Transient
	private String tipoInqui;

	@Transient
	private List<String> itensSelecionados;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoInquilino() {
		return tipoInquilino;
	}

	public void setTipoInquilino(String tipoInquilino) {
		this.tipoInquilino = tipoInquilino;
	}

	public String getTipoInqui() {
		return tipoInqui;
	}

	public void setTipoInqui(String tipoInqui) {
		this.tipoInqui = tipoInqui;
	}

	public List<String> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<String> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}
	
	
	
}
