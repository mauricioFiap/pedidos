/*
package br.com.fiap.msgestaopedidos.service;

import br.com.fiap.msgestaopedidos.entity.Pedido;
import br.com.fiap.msgestaopedidos.repository.PedidoRepository;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;

@EnableBinding(Source.class)
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final Source source;

    public PedidoService(PedidoRepository pedidoRepository, Source source) {
        this.pedidoRepository = pedidoRepository;
        this.source = source;
    }

    public void criarPedido(Pedido pedido) {
        // lógica para criar um pedido

        // publicar um evento quando o pedido é criado
        source.output().send(MessageBuilder.withPayload(pedido).build());
    }
}*/
