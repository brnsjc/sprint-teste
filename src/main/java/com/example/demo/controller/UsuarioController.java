package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRep;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET, produces = "application/json")
	public List<UsuarioEntity> getUsuario() {
		
		List<UsuarioEntity> lista = new ArrayList<UsuarioEntity>();
	
		lista.addAll(usuarioRep.findAll());
		
		ResponseEntity<UsuarioEntity> reponse;
		
		
		return lista;
		
	}
	
	@RequestMapping(value = "/inserirUsuario", method = RequestMethod.POST)
	public UsuarioEntity inserirUsuario(@RequestBody UsuarioEntity usuario) {
		
		
		return usuarioRep.save(usuario);
	}
	
	@RequestMapping(value = "/atualizarUsuario", method = RequestMethod.PUT)
	public UsuarioEntity atualizarUsuario(@RequestBody UsuarioEntity usuario) {
		
		return usuarioRep.save(usuario);
	}
	
	@PutMapping(value = "/atualizarUsuario/{id}")
	public String atualizarUsuarioById(@RequestBody UsuarioEntity usuario ,@PathVariable("id") long id ) {
	
		usuarioRep.save(usuario);
			
	
		return "Oi: " + usuario.getNome().toString()+" "+usuario.getPassword();
	}
}
