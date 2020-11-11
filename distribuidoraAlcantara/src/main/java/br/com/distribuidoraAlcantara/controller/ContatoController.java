package br.com.distribuidoraAlcantara.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidoraAlcantara.model.Contato;
import br.com.distribuidoraAlcantara.service.ContatoService;

@RestController
@RequestMapping("/contatos/api")
public class ContatoController {

	@Autowired
	private ContatoService service;

/* ---------------------------------------------------------------------------------- */	
	
	@PostMapping("/v1")
	public Contato salvarContatoV1(@RequestBody Contato contato) {
		return this.service.salvar(contato);
	}
	
	@PostMapping("/v2")
	public ResponseEntity<Contato> salvarContatoV2(@RequestBody Contato contato) {
		return ResponseEntity.ok().body(this.service.salvar(contato));
	}
	
/* ---------------------------------------------------------------------------------- */

	@GetMapping("/v1")
	public List<Contato> listarContatoV1() {
		return this.service.listaContatos();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Contato>> listarContatoV2() {
		return ResponseEntity.ok().body(this.service.listaContatos());
	}
	
/* ---------------------------------------------------------------------------------- */

	@DeleteMapping("v1/{id}")
	public void deletarContatoV1(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdContato(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Contato> deletarContatoV2(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.service.buscaPorIdContato(id));
	}
	
/* ---------------------------------------------------------------------------------- */

	@PutMapping("v1/{id}")
	public Contato editarContatoV1(@PathVariable Long id, @RequestBody Contato contato) {
		Contato contatoEditar = this.service.buscaPorIdContato(id);
		BeanUtils.copyProperties(contato, contatoEditar, "id");
		this.service.salvar(contatoEditar);
		return contatoEditar;
	}

	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Contato> editarContatoV2(@PathVariable Long id, @RequestBody Contato contato) {
		Contato contatoEditar = this.service.buscaPorIdContato(id);
		BeanUtils.copyProperties(contato, contatoEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(contatoEditar));
	}
	
}
