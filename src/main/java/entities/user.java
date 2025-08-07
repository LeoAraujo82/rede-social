package entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity

public class usuario {
    @Id
    GeneratedValue
    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
private List<Postagem> postagens;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL )
private List<Curtida> curtidas;
