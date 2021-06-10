package com.desafio.gerenciamento.modelos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private String nome;
    @Column(unique = true, nullable = true, length = 14)
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;
    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "dth_criado_em", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @JsonIgnore
    private LocalDateTime dataCriadoEm = LocalDateTime.now();

}
