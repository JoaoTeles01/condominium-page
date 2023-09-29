package com.example.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.teste.entity.Inquilino;

public interface InquilinoRepository extends JpaRepository<Inquilino, String>{
	
	@Query(value= "SELECT * FROM condominio.inqui_cond WHERE tipo_inquilino = 'A' order by cpf asc" , nativeQuery = true)
	public Inquilino getOrdenarAluguel ();
	
	@Query(value= "SELECT * FROM condominio.inqui_cond WHERE tipo_inquilino = 'Q' order by cpf asc" , nativeQuery = true)
	public List<Inquilino> getOrdenarQuitado ();

}
