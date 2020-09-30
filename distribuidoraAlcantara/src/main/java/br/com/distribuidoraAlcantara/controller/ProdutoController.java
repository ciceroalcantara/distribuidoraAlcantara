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

import br.com.distribuidoraAlcantara.model.Produto;
import br.com.distribuidoraAlcantara.repository.ProdutoRepository;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public Produto salvarProduto(@RequestBody Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@GetMapping
	public List<Produto> listarProduto() {
		return this.produtoRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		this.produtoRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Produto editarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		Produto produtoEditar = this.produtoRepository.findById(id).get();
		BeanUtils.copyProperties(produto, produtoEditar, "id");
		this.produtoRepository.save(produtoEditar);
		return produtoEditar;
	}
}
