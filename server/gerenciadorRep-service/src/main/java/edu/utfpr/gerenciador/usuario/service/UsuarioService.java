package edu.utfpr.gerenciador.usuario.service;


import edu.utfpr.gerenciador.usuario.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> lista = new ArrayList<>();

    public Usuario save(Usuario usuario){
        lista.add(usuario);

        return usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void delete(long id){
        lista.removeIf(item -> item.getId() == id);
    }

    public void update(Usuario usuario){
        for (Usuario item : lista){
            if (item.getId() == usuario.getId()){
                item.setNome(usuario.getNome());
            }
        }

    }
}
