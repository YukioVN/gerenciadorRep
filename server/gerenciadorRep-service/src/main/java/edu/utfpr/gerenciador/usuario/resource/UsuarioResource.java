package edu.utfpr.gerenciador.usuario.resource;

import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios")
    public List<Usuario> usuarios(@RequestParam(value = "name", required = false) String nome) {
        final List<Usuario> lista = usuarioService.getLista();
        final List<Usuario> listaRetorno = new ArrayList<>();
        for (Usuario usuario : lista) {
            if (nome == null || usuario.getNome().contains(nome)) {
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
        usuarioService.update(usuario);
    }

    @DeleteMapping("/usuario")
    public void delete(@RequestParam(value = "id", required = true) long id) {
        usuarioService.delete(id);
    }
}