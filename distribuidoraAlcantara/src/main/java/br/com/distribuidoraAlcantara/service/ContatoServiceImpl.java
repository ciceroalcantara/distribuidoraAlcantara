/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.model.Contato;
import br.com.distribuidoraAlcantara.repository.ContatoRepository;

/**
 * @author cicer
 *
 */

@Service
public class ContatoServiceImpl implements ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;

	@Transactional
	@Override
	public Contato salvar(Contato contato) {
		return this.contatoRepository.save(contato);
	}

	@Transactional
	@Override
	public void remover(Contato contato) {
		this.contatoRepository.delete(contato);
	}

	@Override
	public List<Contato> listaContatos() {
		return this.contatoRepository.findAll();
	}

	@Override
	public Contato buscaPorIdContato(Long idContato) {
		return this.contatoRepository.findById(idContato).get();
	}

}
