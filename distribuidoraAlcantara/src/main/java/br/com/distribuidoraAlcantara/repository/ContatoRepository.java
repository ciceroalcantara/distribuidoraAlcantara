package br.com.distribuidoraAlcantara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.distribuidoraAlcantara.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
