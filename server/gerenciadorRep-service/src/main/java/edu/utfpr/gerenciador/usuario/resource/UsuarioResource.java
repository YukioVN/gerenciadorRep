package edu.utfpr.gerenciador.usuario.resource;

import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios")
    public List<Usuario> usuarios(@RequestParam(value = "nickname", required = false) String apelido) {
        final List<Usuario> lista = usuarioService.getLista();
        final List<Usuario> listaRetorno = new ArrayList<>();
        for (Usuario usuario : lista) {
            if (apelido == null || usuario.getApelido().contains(apelido)) {
                listaRetorno.add(usuario);
            }
        }
        return listaRetorno;
    }

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario")
    public void update(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @DeleteMapping("/usuario")
    public ResponseEntity<Void> delete(@RequestParam(value = "id", required = true) long id) {
        if (usuarioService.delete(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}