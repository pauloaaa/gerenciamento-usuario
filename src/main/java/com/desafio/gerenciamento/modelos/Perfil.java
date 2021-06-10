package com.desafio.gerenciamento.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String nome;
    @Column(name = "dth_criado_em", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    private LocalDateTime dataCriadoEm = LocalDateTime.now();

}
