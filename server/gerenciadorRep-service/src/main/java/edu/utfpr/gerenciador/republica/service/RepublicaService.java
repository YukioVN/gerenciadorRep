package edu.utfpr.gerenciador.republica.service;


import edu.utfpr.gerenciador.republica.model.Republica;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepublicaService {

    private List<Republica> lista = new ArrayList<>();

    public Republica save(Republica republica){
        lista.add(republica);

        return republica;
    }

    public List<Republica> getLista() {
        return lista;
    }

    public void delete(long id){
        lista.removeIf(item -> item.getId() == id);
    }

    public void update(Republica republica){
        for (Republica item : lista){
            if (item.getId() == republica.getId()){
                item.setNome(republica.getNome());
                item.setSobrenome(republica.getSobrenome());
                item.setEmail(republica.getEmail());
                item.setApelido(republica.getApelido());

            }
        }

    }
}
