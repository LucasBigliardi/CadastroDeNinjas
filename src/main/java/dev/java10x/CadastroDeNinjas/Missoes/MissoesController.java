package dev.java10x.CadastroDeNinjas.Missoes;

import com.sun.net.httpserver.HttpsServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        MissoesDTO missoes = missoesService.listarMissoesPorId(id);

        if(missoes != null){
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com id: " + id + " nao existe nos registros");
        }
    }

    // POST -- mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes){
        MissoesDTO novaMissao = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNomeMissao() + " (ID): " + novaMissao.getId());
    }

    // PUT -- mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missoes = missoesService.alterarMissao(id, missaoAtualizada);

        if(missoes != null){
            return ResponseEntity.ok(missoes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com ID " + id + " nao existe nos registros.");
        }
    }

    //DELETE -- Mandar uma requisição para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){

        if(missoesService.listarMissoesPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com o ID: " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com o ID: " + id + " nao existe nos registros.");
        }
    }

}
