package com.devwebavancado.CMS.controllers;

import com.devwebavancado.CMS.entidades.Atividade;
import com.devwebavancado.CMS.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> listarAtividades() {
        return atividadeService.listarAtividades();
    }

    @GetMapping("/{id}")
    public Atividade obterAtividade(@PathVariable Long id) {
        return atividadeService.obterAtividade(id);
    }

    @PostMapping
    public Atividade criarAtividade(@RequestBody Atividade atividade) {
        return atividadeService.criarAtividade(atividade);
    }

    @PutMapping("/{id}")
    public Atividade atualizarAtividade(@PathVariable Long id, @RequestBody Atividade atividade) {
        return atividadeService.atualizarAtividade(id, atividade);
    }

    @DeleteMapping("/{id}")
    public void deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarAtividade(id);
    }
}
