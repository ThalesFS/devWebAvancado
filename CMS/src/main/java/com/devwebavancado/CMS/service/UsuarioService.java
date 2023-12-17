package com.devwebavancado.CMS.service;

import com.devwebavancado.CMS.entidades.Atividade;
import com.devwebavancado.CMS.entidades.Usuario;
import com.devwebavancado.CMS.repository.UsuarioRepository;
import com.devwebavancado.CMS.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario obterUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public boolean favoritarAtividade(Long usuarioId, Long atividadeId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        Atividade atividade = atividadeRepository.findById(atividadeId).orElse(null);

        if (usuario != null && atividade != null) {
            usuario.favoritarAtividade(atividade);
            usuarioRepository.save(usuario);
            return true;
        } else {
            return false;
        }
    }

    public boolean desfavoritarAtividade(Long usuarioId, Long atividadeId){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        Atividade atividade = atividadeRepository.findById(atividadeId).orElse(null);

        if (usuario != null && atividade != null) {
            usuario.desfavoritarAtividade(atividade);
            usuarioRepository.save(usuario);
            return true;
        } else {
            return false;
        }
    }
}
