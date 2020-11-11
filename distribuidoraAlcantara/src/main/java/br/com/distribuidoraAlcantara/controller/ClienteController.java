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

import br.com.distribuidoraAlcantara.model.Cliente;
import br.com.distribuidoraAlcantara.service.ClienteService;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/clientes/api")
public class ClienteController {

	@Autowired
	private ClienteService service;

/* ---------------------------------------------------------------------------------- */	
	
	@PostMapping("/v1")
	public Cliente salvarClienteV1(@RequestBody Cliente cliente) {
		return this.service.salvar(cliente);
	}
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvarClienteV2(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(this.service.salvar(cliente));
	}
	
/* ---------------------------------------------------------------------------------- */
	
	@GetMapping("/v1")
	public List<Cliente> listarClientev1() {
		return this.service.listaClientes();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Cliente>> listarClientev2() {
		return ResponseEntity.ok().body(this.service.listaClientes());
	}
	
/* ---------------------------------------------------------------------------------- */
	
	@DeleteMapping("v1/{id}")
	public void deletarClienteV1 (@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdCliente(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Cliente> deletarClienteV2 (@PathVariable Long id) {
		return ResponseEntity.ok().body(this.service.buscaPorIdCliente(id));
	}
	
/* ---------------------------------------------------------------------------------- */	
	
	@PutMapping("v1/{id}")
	public Cliente editarClienteV1(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteEditar = this.service.buscaPorIdCliente(id);
		BeanUtils.copyProperties(cliente, clienteEditar, "id");
		this.service.salvar(clienteEditar);
		return clienteEditar;
	}	
	
	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> editarClienteV2(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteEditar = this.service.buscaPorIdCliente(id);
		BeanUtils.copyProperties(cliente, clienteEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(clienteEditar));
	}	

}
