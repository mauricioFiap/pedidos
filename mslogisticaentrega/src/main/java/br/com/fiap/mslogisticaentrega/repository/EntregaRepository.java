package br.com.fiap.mslogisticaentrega.repository;


import br.com.fiap.mslogisticaentrega.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
