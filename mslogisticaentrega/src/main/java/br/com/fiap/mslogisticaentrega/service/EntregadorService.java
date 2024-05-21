package br.com.fiap.mslogisticaentrega.service;

import br.com.fiap.mslogisticaentrega.entity.Entregador;
import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.repository.EntregadorRepository;
import br.com.fiap.mslogisticaentrega.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private EntregadorRepository entregadorRepository;

    public void atribuirPedidos(List<Pedido> pedidos, Entregador entregador) {
        // lógica para atribuir pedidos ao entregador
        for (Pedido pedido : pedidos) {
            pedido.setEntregador(entregador);
            pedidoRepository.save(pedido);
        }

    }

    public void atualizarStatusEntrega(Pedido pedido, String novoStatus) {
        // lógica para atualizar o status da entrega
        pedido.setStatus(novoStatus);
        pedidoRepository.save(pedido);

    }

    public Entregador findById(Long entregadorId) {
        return entregadorRepository.findById(entregadorId).orElse(null);
    }
}