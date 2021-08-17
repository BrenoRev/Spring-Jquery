package com.brenodev.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenodev.restapi.model.Usuario;
import com.brenodev.restapi.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario save(Usuario usuario) throws Exception {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario atualizarById(Usuario usuario) {
			return usuarioRepository.saveAndFlush(usuario);
	}
	
	public List<Usuario> buscarPorNome(String nome) {
		return usuarioRepository.buscarPorNome(nome);
	}
	}
