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

@Data
@Entity
@Table(name = "tb_fornecedores")
public class Fornecedor {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;

	// Construtor
	public Fornecedor(String nome, String cnpj, String email, String telefone) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
	}

}
