package com.teste3.teste3.domain.pessoa;

import com.teste3.teste3.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;

    @OneToMany
    @JoinColumn(name = "pessoa_id")
    private List<Endereco> endereco = new ArrayList<>();

    public Pessoa(){}

    public Pessoa(String nomeCompleto, LocalDate dataNascimento){
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;

    }


}
