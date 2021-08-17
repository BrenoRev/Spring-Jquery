package com.brenodev.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class principalController {

	@GetMapping("/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public String greeting(@PathVariable String nome) {
		return "Bem vindo " + nome;
	}
	
}
