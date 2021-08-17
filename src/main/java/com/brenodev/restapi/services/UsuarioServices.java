package com.brenodev.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brenodev.restapi.repository.UsuarioRepository;

@Service
public class UsuarioServices {

	@Autowired
	UsuarioRepository usuarioRepository;
}
