package com.devwebavancado.CMS.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ano;
    private int numeroEdicao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "responsavel")
    private Usuario responsavel;

    @OneToMany(mappedBy = "edicao", cascade = CascadeType.ALL)
    private List<Atividade> atividades;
}
