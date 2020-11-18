/**
 * 
 */
package br.com.distribuidoraAlcantara.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

/**
 * @author cicer
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
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

	@OneToOne
	private Usuario usuario;

	@OneToOne
	private Cliente cliente;

	// Gets e Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
