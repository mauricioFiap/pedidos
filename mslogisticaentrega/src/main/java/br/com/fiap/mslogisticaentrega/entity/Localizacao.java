package br.com.fiap.mslogisticaentrega.entity;


import jakarta.persistence.*;

@Entity
public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double latitude;
    private Double longitude;

    @OneToOne(mappedBy = "localizacao")
    private Entregador entregador;

    // getters and setters
}
