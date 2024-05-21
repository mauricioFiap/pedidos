package br.com.fiap.mscliente.controller;

// Controlador ClienteController
import br.com.fiap.mscliente.entity.Cliente;
import br.com.fiap.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*@GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }*/

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
}
