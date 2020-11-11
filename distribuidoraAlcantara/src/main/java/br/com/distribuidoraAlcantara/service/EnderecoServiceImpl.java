/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.model.Endereco;
import br.com.distribuidoraAlcantara.repository.EnderecoRepository;

/**
 * @author cicer
 *
 */

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	@Override
	public Endereco salvar(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Transactional
	@Override
	public void remover(Endereco endereco) {
		this.enderecoRepository.delete(endereco);
	}

	@Override
	public List<Endereco> listaEnderecos() {
		return this.enderecoRepository.findAll();
	}

	@Override
	public Endereco buscaPorIdEndereco(Long idEndereco) {
		return this.enderecoRepository.findById(idEndereco).get();
	}

}
