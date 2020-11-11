/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.exception.EntidadeNaoEncontradaException;
import br.com.distribuidoraAlcantara.model.Produto;
import br.com.distribuidoraAlcantara.repository.ProdutoRepository;

/**
 * @author cicer
 *
 */

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	@Override
	public Produto salvar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public List<Produto> listarProdutos() {
		return this.produtoRepository.findAll();
	}

	/* @Override
	@Transactional
	public void removerPorProduto(Produto produto) {
		this.produtoRepository.delete(produto);
	} */

	@Transactional
	@Override
	public void remover(Produto produto) {
		this.produtoRepository.delete(produto);
	}

	@Override
	public Produto buscaPorId(Long idProduto) {
		Optional<Produto> produto = this.produtoRepository.findById(idProduto);
		if (produto.get() == null) {
			throw new EntidadeNaoEncontradaException("Não foi possível encontrar o produto pesquisado");
		} else {
			return produto.get();
		}
	}

}
