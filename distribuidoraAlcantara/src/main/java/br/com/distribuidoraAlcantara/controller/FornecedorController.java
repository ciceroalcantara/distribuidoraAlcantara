/**
 * 
 */
package br.com.distribuidoraAlcantara.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidoraAlcantara.model.Fornecedor;
import br.com.distribuidoraAlcantara.repository.FornecedorRepository;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@PostMapping
	public Fornecedor salvarFornecedor(@RequestBody Fornecedor fornecedor) {
		return this.fornecedorRepository.save(fornecedor);
	}

	@GetMapping
	public List<Fornecedor> listarFornecedor() {
		return this.fornecedorRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deletarFornecedor(@PathVariable Long id) {
		this.fornecedorRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Fornecedor editarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorEditar = this.fornecedorRepository.findById(id).get();
		BeanUtils.copyProperties(fornecedor, fornecedorEditar, "id");
		this.fornecedorRepository.save(fornecedorEditar);
		return fornecedorEditar;
	}

}
