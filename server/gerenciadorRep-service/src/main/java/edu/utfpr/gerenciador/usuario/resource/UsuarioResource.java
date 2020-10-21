package edu.utfpr.gerenciador.usuario.resource;

import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import edu.utfpr.gerenciador.util.DefaultResponse;
import edu.utfpr.gerenciador.util.GerenciadorRepUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public ResponseEntity<DefaultResponse> save(@RequestBody Usuario usuario) {
        DefaultResponse defaultResponse = new DefaultResponse();

        if(!GerenciadorRepUtil.Validador.isValidEmailAddressRegex(usuario.getEmail())){
            defaultResponse.setCodigoErro(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            defaultResponse.setMensagemErro("E-mail invalido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(defaultResponse);
        }
        defaultResponse.setBody(usuarioService.save(usuario));
        return ResponseEntity.ok(defaultResponse);
    }

//    @PutMapping("/usuario")
//    public ResponseEntity<DefaultResponse> update(@RequestBody Usuario usuario) {
//        DefaultResponse defaultResponse = new DefaultResponse();
//        return usuarioService.save(usuario);
//    }

    @DeleteMapping("/usuario")
    public ResponseEntity<Void> delete(@RequestParam(value = "id", required = true) long id) {
        if (usuarioService.delete(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}