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
@Table(name = "tb_enderecos")
public class Endereco {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String bairro;
	private String cidade;

	// Construtor
	public Endereco(String rua, String bairro, String cidade) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

}
