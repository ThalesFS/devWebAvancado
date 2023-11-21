package com.devwebavancado.CMS.service;

import com.devwebavancado.CMS.entidades.Evento;
import com.devwebavancado.CMS.repository.EventoRepository;
import com.devwebavancado.CMS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Evento obterEvento(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento criarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento atualizarEvento(Long id, Evento evento) {
        if (eventoRepository.existsById(id)) {
            evento.setId(id);
            return eventoRepository.save(evento);
        }
        return null;
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
