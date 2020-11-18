/**
 * 
 */
package br.com.distribuidoraAlcantara.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidoraAlcantara.model.Usuario;
import br.com.distribuidoraAlcantara.service.UsuarioService;
import io.swagger.annotations.ApiOperation;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/usuarios/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

/* ---------------------------------------------------------------------------------- */	
	
	@PostMapping("/v1")
	public Usuario salvarUsuarioV1(@RequestBody Usuario usuario) {
		return this.service.salvar(usuario);
	}
	
	@ApiOperation(
			value="Cadastrar um Usuario novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Usuario.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvarUsuarioV2(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(this.service.salvar(usuario));
	}

/* ---------------------------------------------------------------------------------- */
	
	@GetMapping("/v1")
	public List<Usuario> listarUsuarioV1() {
		return this.service.listaUsuarios();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Usuario>> listarUsuarioV2() {
		return ResponseEntity.ok().body(this.service.listaUsuarios());
	}
	
/* ---------------------------------------------------------------------------------- */

	@DeleteMapping("v1/{id}")
	public void deletarUsuarioV1(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdUsuario(id));
	}
	
	@DeleteMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public String deletarUsuarioV2(@PathVariable Long id) {
		this.service.remover(this.service.buscaPorIdUsuario(id));
		return "Usuario informado excluído com sucesso!";
	}
	
/* ---------------------------------------------------------------------------------- */
	
	@PutMapping("v1/{id}")
	public Usuario editarUsuarioV1(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioEditar = this.service.buscaPorIdUsuario(id);
		BeanUtils.copyProperties(usuario, usuarioEditar, "id");
		this.service.salvar(usuarioEditar);
		return usuarioEditar;
	}
	
	@PutMapping("v2/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Usuario> editarUsuarioV2(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioEditar = this.service.buscaPorIdUsuario(id);
		BeanUtils.copyProperties(usuario, usuarioEditar, "id");
		return ResponseEntity.ok().body(this.service.salvar(usuarioEditar));
	}
	
}
