package br.com.fiap.mslogisticaentrega.controller;

import br.com.fiap.mslogisticaentrega.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.mslogisticaentrega.entity.Entregador;
import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.service.EntregadorService;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/{entregadorId}/atribuir")
    public void atribuirPedidos(@PathVariable Long entregadorId, @RequestBody List<Pedido> pedidos) {
        Entregador entregador = entregadorService.findById(entregadorId);
        entregadorService.atribuirPedidos(pedidos, entregador);
    }

    @PutMapping("/{pedidoId}/status")
    public void atualizarStatusEntrega(@PathVariable Long pedidoId, @RequestBody String novoStatus) {
        Pedido pedido = pedidoService.findById(pedidoId);
        entregadorService.atualizarStatusEntrega(pedido, novoStatus);
    }
}
