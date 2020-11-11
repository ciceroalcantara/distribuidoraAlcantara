/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Contato;

/**
 * @author cicer
 *
 */
public interface ContatoService {
	
	Contato salvar(Contato contato);

	void remover(Contato contato);

	List<Contato> listaContatos();

	Contato buscaPorIdContato(Long idContato);

}
