/**
 * 
 */
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

import br.com.distribuidoraAlcantara.model.Fornecedor;
import br.com.distribuidoraAlcantara.service.FornecedorService;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/fornecedores/api")
public class FornecedorController {

	@Autowired
	private FornecedorService service;

/* ---------------------------------------------------------------------------------- */
	
	@PostMapping("/v1")
	public Fornecedor salvarFornecedorV1(@RequestBody Fornecedor fornecedor) {
		return this.service.salvar(fornecedor);
	}
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> salvarFornecedorV2(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok().body(this.service.salvar(fornecedor));
	}

/* ---------------------------------------------------------------------------------- */
	
	@GetMapping("/v1")
	public List<Fornecedor> listarFornecedorV1() {
		return this.service.listaFornecedores();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Fornecedor>> listarFornecedorV2() {
		return ResponseEntity.ok().body(this.service.listaFornecedores());
	}

/* ---------------------------------------------------------------------------------- */
	
	@DeleteMapping("v1/{id}")
	public void deletarFornecedorV1(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdFornecedor(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Fornecedor> deletarFornecedorV2(@PathVariable Long id) {
		return ResponseEntity.ok().body(this.service.buscaPorIdFornecedor(id));
	}

/* ---------------------------------------------------------------------------------- */
	
	@PutMapping("v1/{id}")
	public Fornecedor editarFornecedorV1(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorEditar = this.service.buscaPorIdFornecedor(id);
		BeanUtils.copyProperties(fornecedor, fornecedorEditar, "id");
		this.service.salvar(fornecedorEditar);
		return fornecedorEditar;
	}
	
	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> editarFornecedorV2(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorEditar = this.service.buscaPorIdFornecedor(id);
		BeanUtils.copyProperties(fornecedor, fornecedorEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(fornecedorEditar));
	}

}
