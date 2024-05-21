package br.com.fiap.mslogisticaentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.mslogisticaentrega.entity.Entregador;
import br.com.fiap.mslogisticaentrega.service.RastreamentoService;

@RestController
@RequestMapping("/rastreamento")
public class RastreamentoController {
    @Autowired
    private RastreamentoService rastreamentoService;

    @PutMapping("/{entregadorId}/localizacao")
    public void atualizarLocalizacaoEntregador(@PathVariable Long entregadorId, @RequestBody Entregador entregador) {
        rastreamentoService.atualizarLocalizacaoEntregador(entregador);
    }
}
