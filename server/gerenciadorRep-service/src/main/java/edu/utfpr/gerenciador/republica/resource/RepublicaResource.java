package edu.utfpr.gerenciador.republica.resource;

import edu.utfpr.gerenciador.republica.model.CaixinhaRequest;
import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.service.RepublicaService;
import edu.utfpr.gerenciador.tarefa.model.Tarefa;
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

    @GetMapping("/republica/{republicaId}")
    public Republica republica(@PathVariable(name = "republicaId") Long republicaId) {
        return republicaService.get(republicaId);
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

    @PostMapping("/republica/{republicaId}/moradores/{moradorId}")
    public void addMorador(@PathVariable(name = "republicaId") Long republicaId,
                           @PathVariable(name = "moradorId") Long moradorId){
        republicaService.addUsuario(republicaId, moradorId);
    }

    @PostMapping("/republica/{republicaId}/tarefa/")
    public void addTarefa(@PathVariable(name = "republicaId") Long republicaId,
                           @RequestBody Tarefa tarefa){
        republicaService.addTarefa(republicaId, tarefa);
    }

    @PostMapping("/republica/{republicaId}/caixinha/")
    public void addTarefa(@PathVariable(name = "republicaId") Long republicaId,
                          @RequestBody CaixinhaRequest caixinhaRequest){
        if (caixinhaRequest.getOperacao().equals(CaixinhaRequest.Operacao.SOMAR)){
            republicaService.somarValorCaixinha(republicaId, caixinhaRequest.getValorOperacao());
        } else if (caixinhaRequest.getOperacao().equals(CaixinhaRequest.Operacao.SUBTRAIR)){
            republicaService.subtrairValorCaixinha(republicaId, caixinhaRequest.getValorOperacao());
        }
    }

}