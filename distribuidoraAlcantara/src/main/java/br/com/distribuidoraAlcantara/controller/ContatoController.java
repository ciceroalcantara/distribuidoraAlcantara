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

import br.com.distribuidoraAlcantara.model.Contato;
import br.com.distribuidoraAlcantara.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;

	@PostMapping
	public Contato salvarCliente(@RequestBody Contato contato) {
		return this.contatoRepository.save(contato);
	}

	@GetMapping
	public List<Contato> listarContato() {
		return this.contatoRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public void deletarContato(@PathVariable Long id) {
		this.contatoRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public Contato editarContato(@PathVariable Long id, @RequestBody Contato contato) {
		Contato contatoEditar = this.contatoRepository.findById(id).get();
		BeanUtils.copyProperties(contato, contatoEditar, "id");
		this.contatoRepository.save(contatoEditar);
		return contatoEditar;
	}

}
