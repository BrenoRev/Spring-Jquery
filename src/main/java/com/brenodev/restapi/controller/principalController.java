package com.brenodev.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brenodev.restapi.model.Usuario;
import com.brenodev.restapi.repository.UsuarioRepository;
import com.brenodev.restapi.services.UsuarioServices;

@RestController
public class principalController {

	@Autowired
	UsuarioServices usuarioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/adicionar")
	@ResponseBody
	public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {

		usuarioService.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	@PutMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {
		if(usuario.getId() == null) {
			return new ResponseEntity<String>("ID não foi informado, impossível concluir a operação", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/listatodos")
	@ResponseBody // Retorna os dados para o corpo da resposta
	public ResponseEntity<List<Usuario>> listaUsuario(){
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); /* Retorna a lista em JSON */
	}
	
	@DeleteMapping("/apagar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long iduser){
		
		usuarioService.deleteById(iduser);
		
		return new ResponseEntity<String>("Usuario deletado com sucesso",HttpStatus.OK);
	}
	
	@GetMapping("buscarusuario/{iduser}")
	@ResponseBody
	public ResponseEntity<Usuario> buscarId(@PathVariable Long iduser){
		
		Usuario user = usuarioService.findById(iduser).get();
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK); 
	}
	
}
