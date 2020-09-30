/**
 * 
 */
package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Endereco;

/**
 * @author cicer
 *
 */

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
