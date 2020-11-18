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

import br.com.distribuidoraAlcantara.model.Endereco;
import br.com.distribuidoraAlcantara.service.EnderecoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/enderecos/api")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

/* ---------------------------------------------------------------------------------- */
	
	@PostMapping("/v1")
	public Endereco salvarEnderecoV1(@RequestBody Endereco endereco) {
		return this.service.salvar(endereco);
	}
	
	@ApiOperation(
			value="Cadastrar um Endereco novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Endereco.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> salvarEnderecoV2(@RequestBody Endereco endereco) {
		return ResponseEntity.ok().body(this.service.salvar(endereco));
	}

/* ---------------------------------------------------------------------------------- */
	
	@GetMapping("/v1")
	public List<Endereco> listarEnderecoV1() {
		return this.service.listaEnderecos();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> listarEnderecoV2() {
		return ResponseEntity.ok().body(this.service.listaEnderecos());
	}

/* ---------------------------------------------------------------------------------- */
	
	@DeleteMapping("v1/{id}")
	public void deletarEnderecoV1(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdEndereco(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String deletarEnderecoV2(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdEndereco(id));
		return "Endereco informado excluído com sucesso!";
	}

/* ---------------------------------------------------------------------------------- */
	
	@PutMapping("v1/{id}")
	public Endereco editarEnderecoV1(@PathVariable Long id, @RequestBody Endereco endereco) {
		Endereco enderecoEditar = this.service.buscaPorIdEndereco(id);
		BeanUtils.copyProperties(endereco, enderecoEditar, "id");
		this.service.salvar(enderecoEditar);
		return enderecoEditar;
	}
	
	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> editarEnderecoV2(@PathVariable Long id, @RequestBody Endereco endereco) {
		Endereco enderecoEditar = this.service.buscaPorIdEndereco(id);
		BeanUtils.copyProperties(endereco, enderecoEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(enderecoEditar));
	}

}
