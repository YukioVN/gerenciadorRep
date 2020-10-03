package edu.utfpr.gerenciador.republica.repository;

import edu.utfpr.gerenciador.republica.model.Republica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepublicaRepository extends JpaRepository<Republica, Long> {
}
