package edu.utfpr.gerenciador.tarefa.service;

import edu.utfpr.gerenciador.tarefa.model.Tarefa;
import edu.utfpr.gerenciador.tarefa.repository.TarefaRepository;
import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa get(Long tarefaId){
        return tarefaRepository.getOne(tarefaId);
    }

    public List<Tarefa> getLista() {
        return tarefaRepository.findAll();
    }

    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public boolean delete(long id) {
        try {
            tarefaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }

    public void atribuirMoradorParaTarefa(Long tarefaId, Long moradorId) {
        Tarefa tarefa = tarefaRepository.getOne(tarefaId);
        Usuario usuario = usuarioService.get(moradorId);

        usuario.getTarefas().add(tarefa);
        tarefa.setUsuarioDesignado(usuario);
        usuarioService.save(usuario);
        tarefaRepository.save(tarefa);
    }
}
