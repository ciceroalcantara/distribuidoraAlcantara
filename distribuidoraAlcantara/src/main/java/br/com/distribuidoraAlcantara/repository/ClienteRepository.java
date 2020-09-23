/**
 * 
 */
package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Cliente;

/**
 * @author cicer
 *
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
