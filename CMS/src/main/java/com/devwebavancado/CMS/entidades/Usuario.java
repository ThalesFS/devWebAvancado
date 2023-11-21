package com.devwebavancado.CMS.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String email;
    private String senha;
    private String afiliacao = "Usuario";

    @ManyToMany
    @JoinTable(name = "usuario_atividade_favorita", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    private Set<Atividade> atividadesFavoritas = new HashSet<>();

    public void favoritarAtividade(Atividade atividade) {
        atividadesFavoritas.add(atividade);
    }

}
