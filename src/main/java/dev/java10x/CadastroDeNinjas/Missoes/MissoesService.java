package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missões
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    // listar missao por id
    public MissoesModel listarMissoesPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
            return missoesPorId.orElse(null);
    }

    //Criar uma missao
    public MissoesModel criarMissao(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    // Deletar missao por id - tem que ser void
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    // Attualizar missão por id
    public MissoesModel alterarMissao(Long id, MissoesModel missaoAtualizada){
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }
}
