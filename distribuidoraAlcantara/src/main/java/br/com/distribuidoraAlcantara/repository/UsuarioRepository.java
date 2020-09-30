/**
 * 
 */
package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Usuario;

/**
 * @author cicer
 *
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
