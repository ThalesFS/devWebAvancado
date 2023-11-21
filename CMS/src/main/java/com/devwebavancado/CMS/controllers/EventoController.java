package com.devwebavancado.CMS.controllers;

import com.devwebavancado.CMS.entidades.Evento;
import com.devwebavancado.CMS.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    @GetMapping("/{id}")
    public Evento obterEvento(@PathVariable Long id) {
        return eventoService.obterEvento(id);
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        return eventoService.criarEvento(evento);
    }

    @PutMapping("/{id}")
    public Evento atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return eventoService.atualizarEvento(id, evento);
    }

    @DeleteMapping("/{id}")
    public void deletarEvento(@PathVariable Long id) {
        eventoService.deletarEvento(id);
    }
}
