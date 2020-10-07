/**
 * 
 */
package br.com.distribuidoraAlcantara.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cicer
 *
 */

@Data
@Entity
@Table(name = "tb_clientes")
public class Cliente {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;

	@OneToMany(mappedBy = "cliente")
	public List<Contato> contatos;

	@OneToOne
	public Endereco endereco;

	@OneToMany(mappedBy = "cliente")
	private List<Produto> produtos;

	// Gets e Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
