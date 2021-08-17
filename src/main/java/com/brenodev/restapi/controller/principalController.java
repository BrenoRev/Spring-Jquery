package com.brenodev.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brenodev.restapi.model.Usuario;
import com.brenodev.restapi.services.UsuarioServices;

@RestController
public class principalController {

	@Autowired
	UsuarioServices usuarioService;
	
	@PostMapping("/adicionar")
	@ResponseBody
	public ResponseEntity<Usuario> greeting(@RequestBody Usuario usuario) {

		usuarioService.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	@GetMapping("/listatodos")
	@ResponseBody // Retorna os dados para o corpo da resposta
	public ResponseEntity<List<Usuario>> listaUsuario(){
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); /* Retorna a lista em JSON */
	}
	
}
