package br.com.fiap.msgestaopedidos.repository;

import br.com.fiap.msgestaopedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // consultas personalizadas podem ser definidas aqui
}
