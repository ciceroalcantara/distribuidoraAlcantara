/**
 * 
 */
package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Fornecedor;

/**
 * @author cicer
 *
 */

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
