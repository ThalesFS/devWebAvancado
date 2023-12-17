package com.devwebavancado.CMS.controllers;

import com.devwebavancado.CMS.entidades.Edicao;
import com.devwebavancado.CMS.service.EdicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edicoes")
public class EdicaoController {

    @Autowired
    private EdicaoService edicaoService;

    @GetMapping
    public List<Edicao> listarEdicoes(){
        return edicaoService.listarEdicoes();
    }

    @GetMapping("/{id}")
    public Edicao obterEdicao(@PathVariable Long id){
        return edicaoService.obterEdicao(id);
    }

    @PostMapping
    public Edicao criarEdicao(@RequestBody Edicao edicao){
        return edicaoService.criarEdicao(edicao);
    }

    @PutMapping("/{id}")
    public Edicao atualizarEdicao(@PathVariable Long id, @RequestBody Edicao edicao){
        return edicaoService.atualizarEdicao(id, edicao);
    }

    @DeleteMapping("/{id}")
    public void deletarEdicao(@PathVariable Long id){
        edicaoService.deletarEdicao(id);
    }
}
