package com.desafio.gerenciamento.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Usuario extends Pessoa {

    @OneToOne
    @JoinColumn(nullable = false, name = "cargo_id")
    private Cargo cargo;
    @OneToMany
    @JoinColumn(name = "usuario_id")
    private List<Perfil> perfil;
}
