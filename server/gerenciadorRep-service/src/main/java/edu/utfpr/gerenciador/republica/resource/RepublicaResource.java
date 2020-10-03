package edu.utfpr.gerenciador.republica.resource;

import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.service.RepublicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RepublicaResource {

    @Autowired
    private RepublicaService republicaService;


    @GetMapping("/republicas")
    public List<Republica> republicas(@RequestParam(value = "name", required = false) String nome) {
        final List<Republica> lista = republicaService.getLista();
        final List<Republica> listaRetorno = new ArrayList<>();
        for (Republica republica : lista) {
            if (nome == null || republica.getNome().contains(nome)) {
                listaRetorno.add(republica);
            }
        }
        return listaRetorno;
    }

    @PostMapping("/republica")
    public Republica save(@RequestBody Republica republica) {
        return republicaService.save(republica);
    }

    @PutMapping("/republica")
    public void update(@RequestBody Republica republica) {
        republicaService.save(republica);
    }

    @DeleteMapping("/republica")
    public ResponseEntity<Void> delete(@RequestParam(value = "id", required = true) long id) {
        if (republicaService.delete(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}