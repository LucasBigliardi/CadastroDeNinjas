package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;
    private final MissoesRepository missoesRepository;

    public MissoesController(MissoesService missoesService, MissoesRepository missoesRepository) {
        this.missoesService = missoesService;
        this.missoesRepository = missoesRepository;
    }

    // GET -- mandar uma requisição para listar as missoes
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    // POST -- mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);
    }

    // PUT -- mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada){
        return missoesService.alterarMissao(id, missaoAtualizada);
    }

    //DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
    }

}
