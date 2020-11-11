/**
 * 
 */
package br.com.distribuidoraAlcantara.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.distribuidoraAlcantara.model.Usuario;
import br.com.distribuidoraAlcantara.repository.UsuarioRepository;

/**
 * @author cicer
 *
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public Usuario salvar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Transactional
	@Override
	public void remover(Usuario usuario) {
		this.usuarioRepository.delete(usuario);
	}

	@Override
	public List<Usuario> listaUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario buscaPorIdUsuario(Long idUsuario) {
		return this.usuarioRepository.findById(idUsuario).get();
	}

}
