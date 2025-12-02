package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table (name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomeMissao;
    private String dificuldade;

    private NinjaModel ninja;

}
