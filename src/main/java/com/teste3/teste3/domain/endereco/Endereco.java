package com.teste3.teste3.domain.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "enderecos")
@Table(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private String estado;


}
