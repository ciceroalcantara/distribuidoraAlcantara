/**
 * 
 */
package br.com.distribuidoraAlcantara.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidoraAlcantara.model.Usuario;
import br.com.distribuidoraAlcantara.repository.UsuarioRepository;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@GetMapping
	public List<Usuario> listarUsuario() {
		return this.usuarioRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable Long id) {
		this.usuarioRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioEditar = this.usuarioRepository.findById(id).get();
		BeanUtils.copyProperties(usuario, usuarioEditar, "id");
		this.usuarioRepository.save(usuarioEditar);
		return usuarioEditar;
	}
}
