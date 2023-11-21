package com.devwebavancado.CMS.service;

import com.devwebavancado.CMS.entidades.Espaco;
import com.devwebavancado.CMS.repository.EspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository espacoRepository;

    public List<Espaco> listarEspacos() {
        return espacoRepository.findAll();
    }

    public Espaco obterEspaco(Long id) {
        return espacoRepository.findById(id).orElse(null);
    }

    public Espaco criarEspaco(Espaco espaco) {
        return espacoRepository.save(espaco);
    }

    public Espaco atualizarEspaco(Long id, Espaco espaco) {
        if (espacoRepository.existsById(id)) {
            espaco.setId(id);
            return espacoRepository.save(espaco);
        }
        return null;
    }

    public void deletarEspaco(Long id) {
        espacoRepository.deleteById(id);
    }
}
