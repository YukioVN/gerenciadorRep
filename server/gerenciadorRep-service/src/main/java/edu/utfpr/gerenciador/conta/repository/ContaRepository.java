package edu.utfpr.gerenciador.conta.repository;

import edu.utfpr.gerenciador.conta.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findAllByRepublicaId(Long republicaId);
}
