package br.com.fiap.mslogisticaentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.mslogisticaentrega.entity.Pedido;
import br.com.fiap.mslogisticaentrega.service.LogService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private LogService logService;

    @PostMapping("/processar")
    public void processarPedidos() {
        logService.processarPedidos();
    }
}
