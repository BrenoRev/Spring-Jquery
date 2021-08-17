package com.brenodev.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brenodev.restapi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "SELECT u FROM Usuario u WHERE lower(trim(u.nome)) LIKE %?1%")
	List<Usuario> buscarPorNome(String nome);
	
}
