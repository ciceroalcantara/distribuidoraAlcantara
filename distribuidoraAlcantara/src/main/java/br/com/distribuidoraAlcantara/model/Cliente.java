/**
 * 
 */
package br.com.distribuidoraAlcantara.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author cicer
 *
 */

@Data // Cria automatico os Gets e os Sets no lombok
@Entity
@Table(name = "tb_clientes")
public class Cliente {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;

	// Construtor
	public Cliente(String nome, String cpf, String email, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

}
