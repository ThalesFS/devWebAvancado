package com.devwebavancado.CMS.controllers;

import com.devwebavancado.CMS.entidades.Espaco;
import com.devwebavancado.CMS.service.EspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacos")
public class EspacoController {

    @Autowired
    private EspacoService espacoService;

    @GetMapping
    public List<Espaco> listarEspacos() {
        return espacoService.listarEspacos();
    }

    @GetMapping("/{id}")
    public Espaco obterEspaco(@PathVariable Long id) {
        return espacoService.obterEspaco(id);
    }

    @PostMapping
    public Espaco criarEspaco(@RequestBody Espaco espaco) {
        return espacoService.criarEspaco(espaco);
    }

    @PutMapping("/{id}")
    public Espaco atualizarEspaco(@PathVariable Long id, @RequestBody Espaco espaco) {
        return espacoService.atualizarEspaco(id, espaco);
    }

    @DeleteMapping("/{id}")
    public void deletarEspaco(@PathVariable Long id) {
        espacoService.deletarEspaco(id);
    }

}
