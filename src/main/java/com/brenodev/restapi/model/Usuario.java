package com.brenodev.restapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@NotNull
	@Size(min= 3, max=20)
	private String nome;
	
	@NotNull
	private int idade;
}
