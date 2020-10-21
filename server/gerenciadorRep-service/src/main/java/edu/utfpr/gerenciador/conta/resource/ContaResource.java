package edu.utfpr.gerenciador.conta.resource;

import edu.utfpr.gerenciador.conta.model.Conta;
import edu.utfpr.gerenciador.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @PostMapping("/republica/{republicaId}/conta/")
    public void criarConta(@RequestBody Conta conta){
        contaService.save(conta);
    }

    @PutMapping("/republica/{republicaId}/conta/")
    public void atualizarConta(@RequestBody Conta conta){
        // nao calcula automaticamente a divisao da conta
        contaService.atualizar(conta);
    }

    @GetMapping("/conta/{contaId}")
    public Conta getConta(@PathVariable(name = "contaId") Long contaId){
        return contaService.get(contaId);
    }

    @GetMapping("/republica/{republicaId}/conta/")
    public List<Conta> getContas(@PathVariable(name = "republicaId") Long republicaId){
        return contaService.getLista(republicaId);
    }

    @GetMapping("/conta/")
    public List<Conta> getContas(){
        return contaService.getLista();
    }
}
