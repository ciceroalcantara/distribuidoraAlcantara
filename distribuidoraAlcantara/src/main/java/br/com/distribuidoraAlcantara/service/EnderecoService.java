/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Endereco;

/**
 * @author cicer
 *
 */
public interface EnderecoService {

	Endereco salvar(Endereco endereco);

	void remover(Endereco endereco);

	List<Endereco> listaEnderecos();

	Endereco buscaPorIdEndereco(Long idEndereco);

}
