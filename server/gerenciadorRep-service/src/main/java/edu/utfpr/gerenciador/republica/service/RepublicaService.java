package edu.utfpr.gerenciador.republica.service;


import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.repository.RepublicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepublicaService {

    @Autowired
    private RepublicaRepository republicaRepository;

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
}
