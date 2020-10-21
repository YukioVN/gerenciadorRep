package edu.utfpr.gerenciador.evento.service;

import edu.utfpr.gerenciador.evento.model.Evento;
import edu.utfpr.gerenciador.evento.repository.EventoRepository;
import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento get(Long eventoId){
        return eventoRepository.getOne(eventoId);
    }

    public List<Evento> getLista() {
        return eventoRepository.findAll();
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public boolean delete(long id) {
        try {
            eventoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }
}