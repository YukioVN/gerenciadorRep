package edu.utfpr.gerenciador.evento.repository;

import edu.utfpr.gerenciador.evento.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
