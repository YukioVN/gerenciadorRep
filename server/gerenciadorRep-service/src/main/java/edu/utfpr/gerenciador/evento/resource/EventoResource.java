package edu.utfpr.gerenciador.evento.resource;

import edu.utfpr.gerenciador.evento.model.Evento;
import edu.utfpr.gerenciador.evento.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoResource {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/evento/{eventoId}")
    public Evento getEvento(@PathVariable(name = "eventoId") Long eventoId){
        return eventoService.get(eventoId);
    }
}
