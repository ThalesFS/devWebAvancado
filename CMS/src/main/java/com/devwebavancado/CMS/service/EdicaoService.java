package com.devwebavancado.CMS.service;

import com.devwebavancado.CMS.entidades.Edicao;
import com.devwebavancado.CMS.entidades.Usuario;
import com.devwebavancado.CMS.repository.EdicaoRepository;
import com.devwebavancado.CMS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EdicaoService {

    @Autowired
    private EdicaoRepository edicaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Edicao> listarEdicoes() {
        return edicaoRepository.findAll();
    }

    public Edicao obterEdicao(Long id) {
        return edicaoRepository.findById(id).orElse(null);
    }

    public Edicao criarEdicao(Edicao edicao) {
        return edicaoRepository.save(edicao);
    }

    public Edicao atualizarEdicao(Long id, Edicao edicao) {
        if (edicaoRepository.existsById(id)) {
            edicao.setId(id);
            Usuario responsavel = edicao.getResponsavel();
            responsavel.setAfiliacao("Organizador");
            edicao.setResponsavel(responsavel);
            usuarioRepository.save(responsavel);
            return edicaoRepository.save(edicao);
        }
        return null;
    }

    public void deletarEdicao(Long id) {
        edicaoRepository.deleteById(id);
    }
}
