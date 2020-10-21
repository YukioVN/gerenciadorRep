package edu.utfpr.gerenciador.evento.resource;

import edu.utfpr.gerenciador.evento.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoResource {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/republica/{republicaId}/evento/{eventoId}")
    public void atribuirTarefa(@PathVariable(name = "republicaId") Long republicaId,
                               @PathVariable(name = "eventoId") Long eventoId){
        //tarefaService.atribuirMoradorParaTarefa(tarefaId, moradorId);
    }
}
