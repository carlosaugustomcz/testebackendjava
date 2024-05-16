package com.teste3.teste3.domain.endereco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.teste3.teste3.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Endereco {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;
    private Boolean principal;

    @ManyToOne
    @JoinColumn()
    @JsonBackReference()
    private Pessoa pessoa;

    public Endereco (String logradouro, String cep, String numero, String cidade, String estado, Boolean principal, Pessoa pessoa){
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.principal = principal;
        this.pessoa = pessoa;
    }

    public Endereco(){

    }
}
