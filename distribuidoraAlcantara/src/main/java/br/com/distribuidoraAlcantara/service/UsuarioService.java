/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import br.com.distribuidoraAlcantara.model.Usuario;

/**
 * @author cicer
 *
 */
public interface UsuarioService {
	
	Usuario salvar(Usuario usuario);

	void remover(Usuario usuario);

	List<Usuario> listaUsuarios();

	Usuario buscaPorIdUsuario(Long idUsuario);

}
