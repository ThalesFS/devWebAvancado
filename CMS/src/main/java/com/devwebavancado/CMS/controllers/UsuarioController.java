package com.devwebavancado.CMS.controllers;

import com.devwebavancado.CMS.entidades.Usuario;
import com.devwebavancado.CMS.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obterUsuario(@PathVariable Long id){
        return usuarioService.obterUsuario(id);
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.criarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }

    @PutMapping("/{usuarioId}/favoritar/{atividadeId}")
    public ResponseEntity<String> favoritarAtividade(@PathVariable Long usuarioId, @PathVariable Long atividadeId) {
        boolean sucesso = usuarioService.favoritarAtividade(usuarioId, atividadeId);
        if (sucesso) {
            return ResponseEntity.ok("Atividade favoritada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou Atividade não encontrados.");
        }
    }

    @PutMapping("/{usuarioId}/desfavoritar/{atividadeId}")
    public ResponseEntity<String> desfavoritarAtividade(@PathVariable Long usuarioId, @PathVariable Long atividadeId) {
        boolean sucesso = usuarioService.desfavoritarAtividade(usuarioId, atividadeId);
        if (sucesso) {
            return ResponseEntity.ok("Atividade desfavoritada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou Atividade não encontrados.");
        }
    }


}
