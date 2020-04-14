package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.request.Frase;
import com.example.demo.request.Usuario;
import com.example.demo.service.StorageService;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRep;
	
	@Autowired
	StorageService storage;
	
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
	
	@PostMapping("/upload")
	public String uploadArquivo(@RequestParam("file") MultipartFile file, RedirectAttributes redirect) {
		
		storage.store(file);
		return "Salvou";
	}
	
	@PostMapping(value = "/request", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> testeBody(@RequestBody Usuario ususarioRequest) {
		
		 
		return new ResponseEntity<>(ususarioRequest, HttpStatus.OK);
	}
	
	@GetMapping("/apiSpring")
	public ResponseEntity<Object> testeConsumirApi(){
		
		RestTemplate restTemplate = new RestTemplate();
				
		Frase frase = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Frase.class);
		return new ResponseEntity<Object>(frase, HttpStatus.OK);
	}
	
	
	@GetMapping("/head")
	public ResponseEntity<Object> testeServlet(){
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("entiti", "get header");
		return ResponseEntity.ok().headers(headers).body("GET e header com ReponseEntity");
	}
}
