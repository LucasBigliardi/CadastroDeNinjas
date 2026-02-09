package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nomeMissao;
    private String dificuldade;

    //@OneToMany uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

    public MissoesModel(String nomeMissao, String dificuldade){
        this.nomeMissao = nomeMissao;
        this.dificuldade = dificuldade;
    }
}
