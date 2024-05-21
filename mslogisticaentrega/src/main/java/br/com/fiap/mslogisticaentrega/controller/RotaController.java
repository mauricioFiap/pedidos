package br.com.fiap.mslogisticaentrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.mslogisticaentrega.service.RotaService;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    @Autowired
    private RotaService rotaService;

    @GetMapping("/calcular")
    public void calcularRota(@RequestParam String origem, @RequestParam String destino) {
        rotaService.calcularRota(origem, destino);
    }
}
