package com.higo.learning.services;

import com.higo.learning.domain.Cidade;
import com.higo.learning.domain.Estado;
import com.higo.learning.repositories.CidadeRepository;
import com.higo.learning.repositories.EstadoRepository;
import com.higo.learning.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> findByEstado(Integer estadoId) {
        Optional<Estado> estado = estadoRepository.findById(estadoId);
        if(estado.isEmpty()) {
            throw new ObjectNotFoundException("Estado não encontrado");
        }
        return cidadeRepository.findCidadeByEstadoOrderByNome(estado.get());
    }

}
