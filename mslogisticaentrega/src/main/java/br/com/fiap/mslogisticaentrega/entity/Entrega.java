package br.com.fiap.mslogisticaentrega.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subSetorCEP;

    @OneToMany
    private List<Pedido> pedidos;

    // getters and setters
}
