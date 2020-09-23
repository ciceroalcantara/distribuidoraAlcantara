/**
 * 
 */
package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Produto;

/**
 * @author cicer
 *
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
