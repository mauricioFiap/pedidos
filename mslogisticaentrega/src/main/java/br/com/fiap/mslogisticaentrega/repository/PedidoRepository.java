package br.com.fiap.mslogisticaentrega.repository;

import br.com.fiap.mslogisticaentrega.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(String status);
    List<Pedido> findByEnderecoContaining(String subSetorCEP);
}
