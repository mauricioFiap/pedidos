package br.com.fiap.mslogisticaentrega.repository;

import br.com.fiap.mslogisticaentrega.entity.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    List<Entregador> findByStatus(String status);
}