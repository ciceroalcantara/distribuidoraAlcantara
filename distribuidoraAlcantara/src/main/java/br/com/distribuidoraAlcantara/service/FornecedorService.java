/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Fornecedor;

/**
 * @author cicer
 *
 */
public interface FornecedorService {

	Fornecedor salvar(Fornecedor fornecedor);

	void remover(Fornecedor fornecedor);

	List<Fornecedor> listaFornecedores();

	Fornecedor buscaPorIdFornecedor(Long idFornecedor);

}
