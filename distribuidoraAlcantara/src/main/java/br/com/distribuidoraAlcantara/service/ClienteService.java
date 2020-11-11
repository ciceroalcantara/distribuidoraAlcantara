/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Cliente;

/**
 * @author cicer
 *
 */
public interface ClienteService {

	Cliente salvar(Cliente cliente);

	void remover(Cliente cliente);

	List<Cliente> listaClientes();

	Cliente buscaPorIdCliente(Long idCliente);

}
