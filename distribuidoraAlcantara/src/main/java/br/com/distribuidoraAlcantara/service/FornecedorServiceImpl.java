/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.model.Fornecedor;
import br.com.distribuidoraAlcantara.repository.FornecedorRepository;

/**
 * @author cicer
 *
 */

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	@Override
	public Fornecedor salvar(Fornecedor fornecedor) {
		return this.fornecedorRepository.save(fornecedor);
	}

	@Transactional
	@Override
	public void remover(Fornecedor fornecedor) {
		this.fornecedorRepository.delete(fornecedor);
	}

	@Override
	public List<Fornecedor> listaFornecedores() {
		return this.fornecedorRepository.findAll();
	}

	@Override
	public Fornecedor buscaPorIdFornecedor(Long idFornecedor) {
		return this.fornecedorRepository.findById(idFornecedor).get();
	}

}
