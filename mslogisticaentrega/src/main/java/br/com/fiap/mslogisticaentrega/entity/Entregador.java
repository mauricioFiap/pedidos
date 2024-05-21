package br.com.fiap.mslogisticaentrega.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Entregador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String veiculo;
    private String status;

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> entregasAtribuidas;

    // getters and setters
}
