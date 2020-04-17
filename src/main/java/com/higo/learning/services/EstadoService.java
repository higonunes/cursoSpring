package com.higo.learning.services;

import com.higo.learning.domain.Estado;
import com.higo.learning.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado>findAll() {
        return estadoRepository.findAllByOrderByNome();
    }
}
