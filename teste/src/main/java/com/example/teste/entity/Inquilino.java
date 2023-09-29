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
@Table(name = "inqui_cond", schema = "condominio")
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
}
