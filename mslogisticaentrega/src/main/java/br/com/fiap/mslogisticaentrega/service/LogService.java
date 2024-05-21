package br.com.fiap.mslogisticaentrega.service;

import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.entity.Entrega;
import br.com.fiap.mslogisticaentrega.repository.EntregaRepository;
import br.com.fiap.mslogisticaentrega.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private EntregaRepository entregaRepository;

    public void processarPedidos() {
        List<Pedido> pedidosEmAberto = pedidoRepository.findByStatus("Em Aberto");

        pedidosEmAberto.stream()
            .collect(Collectors.groupingBy(pedido -> pedido.getEndereco().substring(0, 5))) // agrupar por sub-setor de CEP
            .forEach((subSetorCEP, pedidos) -> {
                Entrega entrega = new Entrega(); // criar nova entrega
                entrega.setPedidos(pedidos);
                entrega.setSubSetorCEP(subSetorCEP);
                entregaRepository.save(entrega); // salvar entrega

                pedidos.forEach(pedido -> {
                    pedido.setStatus("Em Preparo para Envio"); // alterar status do pedido
                    pedidoRepository.save(pedido); // salvar pedido
                });
            });
    }
}