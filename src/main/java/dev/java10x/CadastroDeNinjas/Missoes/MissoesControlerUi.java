package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControlerUi {

    private final MissoesService missoesService;

    public MissoesControlerUi(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id){
        missoesService.deletarMissaoPorId(id);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarMissoesPorId(@PathVariable Long id, Model model){
        MissoesDTO missao = missoesService.listarMissoesPorId(id);
        if(missao != null){
            model.addAttribute("missao", missao);
            return "detalhesmissao";
        } else {
            model.addAttribute("mensagem", "Missão não encontrada");
            return "listarMissoes";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarMissao(Model model){
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissoes";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes){
        missoesService.criarMissao(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missão cadastrada com sucesso!");
        return "redirect:/missoes/ui/listar";
    }
}
