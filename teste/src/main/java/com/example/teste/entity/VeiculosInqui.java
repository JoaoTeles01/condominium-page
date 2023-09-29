package com.example.teste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "VeiculosInqui", schema = "condominio")
public class VeiculosInqui {
	
	@Id
	@Column(name = "placa")
	private String placa;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "corveiculo")
	private String corVeiculo;

}
