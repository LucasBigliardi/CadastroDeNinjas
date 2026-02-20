package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nesse rota";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Mostrar Ninjas";
    }

    //Mostrar ninjas por ID
    @GetMapping("/todosID")
    public String mostrarTodosPorId(){
        return "Mostrar Ninjas por ID";
    }

    //alterar dados dos ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarPorID")
    public String deletarPorId(){
        return "Ninja Deletado por ID";
    }
}
