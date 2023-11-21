package com.devwebavancado.CMS.service;

import com.devwebavancado.CMS.entidades.Atividade;
import com.devwebavancado.CMS.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public Atividade obterAtividade(Long id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public Atividade criarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Atividade atualizarAtividade(Long id, Atividade atividade) {
        if (atividadeRepository.existsById(id)) {
            atividade.setId(id);
            return atividadeRepository.save(atividade);
        }
        return null;
    }

    public void deletarAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}
