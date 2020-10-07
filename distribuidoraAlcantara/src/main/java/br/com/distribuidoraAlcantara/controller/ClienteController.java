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

import br.com.distribuidoraAlcantara.model.Cliente;
import br.com.distribuidoraAlcantara.repository.ClienteRepository;

/**
 * @author cicer
 *
 */

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	// Composição da classe ClienteRepository com a classe ClienteController, junção
	// do controller com o banco de dados.
	@Autowired // A classe ClienteRepository foi instanciada e ela esta sendo injetada dentro do controlador atraves da anotação "@Autowired"
	private ClienteRepository clienteRepository;

	// Método para salvar dados de cliente no banco de dados.
	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) { // A anotação @RequestBody pega os dados que vão no corpo da requisição e joga dentro da tabela de cliente no banco de dados
		return this.clienteRepository.save(cliente);
	}

	// Método para listar todos os clientes no banco de dados
	@GetMapping
	public List<Cliente> listarCliente() {
		return this.clienteRepository.findAll();
	}
	
	// Método para deletar um cliente pelo Id
	@DeleteMapping("/{id}")
	public void deletarCliente (@PathVariable Long id) { // O @PathVariable é utilizado quando o valor da variável é passada diretamente na URL
		this.clienteRepository.deleteById(id);
	}
	
	// Método para editar um registro de um cliente pelo id
	@PutMapping("/{id}")
	public Cliente editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteEditar = this.clienteRepository.findById(id).get();
		BeanUtils.copyProperties(cliente, clienteEditar, "id");
		this.clienteRepository.save(clienteEditar);
		return clienteEditar;
	}	

}
