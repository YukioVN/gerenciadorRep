package edu.utfpr.gerenciador.usuario.resource;

import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/usuarios")
    public List<Usuario> usuarios(@RequestParam(value = "name", required = false) String nome) {
        final List<Usuario> lista = usuarioService.getLista();
        final List<Usuario> listaRetorno = new ArrayList<>();
        for(Usuario usuario: lista){
            if(nome == null || usuario.getNome().contains(nome)){
                listaRetorno.add(usuario);
            }
        }
        return listaRetorno;
    }

    @PostMapping("/usuario")
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario")
    public void update(@RequestParam(value = "id", required = true) long id, @RequestParam(value = "name", required = true) String nome, @RequestParam(value = "sobrenome", required = true) String sobrenome, @RequestParam(value = "apelido", required = true) String apelido, @RequestParam(value = "email", required = true) String email){
        usuarioService.update(new Usuario(id, nome, sobrenome, apelido, email));
    }

    @DeleteMapping("/usuario")
    public void delete(@RequestParam(value = "id", required = true) long id){
        usuarioService.delete(id);
    }
}