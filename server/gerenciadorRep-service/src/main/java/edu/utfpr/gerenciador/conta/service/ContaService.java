package edu.utfpr.gerenciador.conta.service;

import edu.utfpr.gerenciador.conta.model.Conta;
import edu.utfpr.gerenciador.conta.repository.ContaRepository;
import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.republica.repository.RepublicaRepository;
import edu.utfpr.gerenciador.usuario.model.Usuario;
import edu.utfpr.gerenciador.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private RepublicaRepository republicaRepository;

    public Conta get(Long contaId){
        return contaRepository.getOne(contaId);
    }

    public List<Conta> getLista() {
        return contaRepository.findAll();
    }

    public List<Conta> getLista(Long republicaId) {
        return contaRepository.findAllByRepublicaId(republicaId);
    }

    public Conta save(Conta conta) {

        Republica republica = republicaRepository.getOne(conta.getRepublica().getId());

        int numeroMoradoresRepublica = republica.getMoradores().size();
        conta.setNumeroPessoasParaRateiro(numeroMoradoresRepublica);
        conta.setValorPorPessoa(conta.getValorDespesa() / numeroMoradoresRepublica);

        return contaRepository.save(conta);
    }

    public Conta atualizar(Conta conta) {
        return contaRepository.save(conta);
    }

    public boolean delete(long id) {
        try {
            contaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }
}
