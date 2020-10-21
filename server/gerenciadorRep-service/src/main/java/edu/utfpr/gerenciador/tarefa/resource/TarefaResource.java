package edu.utfpr.gerenciador.tarefa.resource;

import edu.utfpr.gerenciador.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaResource {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/republica/{republicaId}/tarefa/{tarefaId}/morador/{moradorId}")
    public void atribuirTarefa(@PathVariable(name = "republicaId") Long republicaId,
                               @PathVariable(name = "tarefaId") Long tarefaId,
                               @PathVariable(name = "moradorId") Long moradorId){
        tarefaService.atribuirMoradorParaTarefa(tarefaId, moradorId);
    }
}
