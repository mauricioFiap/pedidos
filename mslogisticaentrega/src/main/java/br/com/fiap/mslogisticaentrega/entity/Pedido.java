package br.com.fiap.mslogisticaentrega.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCliente;
    private String endereco;
    private String status;
    private LocalDateTime dataHoraPedido;
    private LocalDateTime dataHoraEntregaEstimada;

    @ManyToOne
    private Entregador entregador;

    // getters and setters
}
