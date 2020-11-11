/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.exception.EntidadeComDependencias;
import br.com.distribuidoraAlcantara.model.Cliente;
import br.com.distribuidoraAlcantara.repository.ClienteRepository;

/**
 * @author cicer
 *
 */

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Transactional
	@Override
	public Cliente salvar(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Transactional
	@Override
	public void remover(Cliente cliente) {
		if(!cliente.getProdutos().isEmpty()) {
			throw new EntidadeComDependencias("Erro ao excluir, cliente com produtos vinculados");
		} else {
			this.clienteRepository.delete(cliente);
		}
	}

	@Override
	public List<Cliente> listaClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente buscaPorIdCliente(Long idCliente) {
		return this.clienteRepository.findById(idCliente).get();
	}

}
