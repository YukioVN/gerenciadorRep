package edu.utfpr.gerenciador.homepage.resource;

import edu.utfpr.gerenciador.homepage.model.HomePageResponse;
import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.service.RepublicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
public class HomePageResource {

    @Autowired
    private RepublicaService republicaService;

    @GetMapping("/republica/{republicaId}/acoes-do-dia/")
    public HomePageResponse acoesDoDia(@PathVariable(name = "republicaId") Long republicaId, @RequestParam(value = "data", required = false) String data) {
        LocalDate localDate = LocalDate.parse(data);

        HomePageResponse response = new HomePageResponse();
        Republica republica = republicaService.get(republicaId);
        response.setRepublica(republica);

        response.setContas(republica.getContas().stream().filter(conta -> conta.getDataVencimento().equals(localDate)).collect(Collectors.toList()));
        response.setEventos(republica.getEventos().stream().filter(conta -> conta.getDataEvento().equals(localDate)).collect(Collectors.toList()));
        response.setTarefas(republica.getTarefas().stream().filter(conta -> conta.getDataLimite().equals(localDate)).collect(Collectors.toList()));

        return response;
    }

}