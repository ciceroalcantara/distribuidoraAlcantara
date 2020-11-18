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

import br.com.distribuidoraAlcantara.model.Produto;
import br.com.distribuidoraAlcantara.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/produtos/api")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

/* ---------------------------------------------------------------------------------- */
	
	@PostMapping("/v1")
	public Produto salvarProdutoV1(@RequestBody Produto produto) {
		return this.service.salvar(produto);
	}
	
	@ApiOperation(
			value="Cadastrar um Produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Produto.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> salvarProdutoV2(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(this.service.salvar(produto));
	}

/* ---------------------------------------------------------------------------------- */
	
	@GetMapping("/v1")
	public List<Produto> listarProdutoV1() {
		return this.service.listarProdutos();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Produto>> listarProdutoV2() {
		return ResponseEntity.ok().body(this.service.listarProdutos());
	}

/* ---------------------------------------------------------------------------------- */
	
	@DeleteMapping("v1/{id}")
	public void deletarProdutoV1(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorId(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String deletarProdutoV2(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorId(id));
		return "Produto informado excluído com sucesso!";
	}

/* ---------------------------------------------------------------------------------- */
	
	@PutMapping("v1/{id}")
	public Produto editarProdutoV1(@PathVariable Long id, @RequestBody Produto produto) {
		Produto produtoEditar = this.service.buscaPorId(id);
		BeanUtils.copyProperties(produto, produtoEditar, "id");
		this.service.salvar(produtoEditar);
		return produtoEditar;
	}
	
	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> editarProdutoV2(@PathVariable Long id, @RequestBody Produto produto) {
		Produto produtoEditar = this.service.buscaPorId(id);
		BeanUtils.copyProperties(produto, produtoEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(produtoEditar));
	}
	
}
