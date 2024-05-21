package br.com.fiap.mslogisticaentrega.service;

import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        return optionalPedido.orElse(null);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
