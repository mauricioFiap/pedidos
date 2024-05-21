package br.com.fiap.mslogisticaentrega.service;

import br.com.fiap.mslogisticaentrega.entity.Entregador;
import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.repository.EntregadorRepository;
import br.com.fiap.mslogisticaentrega.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RastreamentoService {
    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public void atualizarLocalizacaoEntregador(Entregador entregador) {
        // lógica para atualizar a localização do entregador
        entregadorRepository.save(entregador);

    }

    public Entregador findById(Long entregadorId) {
        return entregadorRepository.findById(entregadorId).orElse(null);
    }

    public void deleteEntregador(Long entregadorId) {
        entregadorRepository.deleteById(entregadorId);
    }

    public Entregador saveEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public void atribuirEntregadorPedido(Long entregadorId, Long pedidoId) {
        Entregador entregador = entregadorRepository.findById(entregadorId).orElse(null);
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);

        if (entregador != null && pedido != null) {
            pedido.setEntregador(entregador);
            pedidoRepository.save(pedido);
        }
    }

    public void atualizarStatusEntrega(Long pedidoId, String novoStatus) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElse(null);

        if (pedido != null) {
            pedido.setStatus(novoStatus);
            pedidoRepository.save(pedido);
        }
    }

    public Pedido findByIdPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }

    public void deletePedido(Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }


}
