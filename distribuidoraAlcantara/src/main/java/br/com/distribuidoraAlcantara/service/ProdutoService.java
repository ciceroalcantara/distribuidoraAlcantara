/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Produto;

/**
 * @author cicer
 *
 */
public interface ProdutoService {

	Produto salvar(Produto produto); //ok

	List<Produto> listarProdutos(); //ok

	/* void removerPorProduto(Produto produto); */

	void remover(Produto produto); //ok

	Produto buscaPorId(Long idProduto);

}
