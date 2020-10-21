package edu.utfpr.gerenciador.republica.service;


import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.repository.RepublicaRepository;
import edu.utfpr.gerenciador.tarefa.model.Tarefa;
import edu.utfpr.gerenciador.tarefa.repository.TarefaRepository;
import edu.utfpr.gerenciador.tarefa.service.TarefaService;
import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepublicaService {

    @Autowired
    private RepublicaRepository republicaRepository;

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private UsuarioService usuarioService;

    public List<Republica> getLista() {
        return republicaRepository.findAll();
    }

    public Republica save(Republica republica) {
        return republicaRepository.save(republica);
    }

    public boolean delete(long id) {
        try {
            republicaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }

    public void addUsuario(Long republicaId, Long usuarioId){
        Usuario usuario = usuarioService.get(usuarioId);
        Republica republica = republicaRepository.getOne(republicaId);

        usuario.setRepublica(republica);
        republica.getMoradores().add(usuario);

        republicaRepository.save(republica);
        usuarioService.save(usuario);
    }

    public Republica get(Long republicaId) {
        return republicaRepository.getOne(republicaId);
    }

    public void addTarefa(Long republicaId, Tarefa tarefaNova) {
        Republica republica = republicaRepository.getOne(republicaId);

        Tarefa tarefa = tarefaService.save(tarefaNova);

        republica.getTarefas().add(tarefa);
        republicaRepository.save(republica);
    }

}
