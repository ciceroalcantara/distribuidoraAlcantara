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
@Table(name = "tb_produtos")
public class Produto {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int codigo;
	private double preco;

	// Construtor
	public Produto(String nome, int codigo, double preco) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
	}

}