package com.higo.learning.resources;

import com.higo.learning.domain.Estado;
import com.higo.learning.dto.CidadeDTO;
import com.higo.learning.services.CidadeService;
import com.higo.learning.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<Estado>> listAll() {
        return ResponseEntity.ok().body(estadoService.findAll());
    }

    @GetMapping(value = "/{estado_id}/cidades")
    public ResponseEntity<List<CidadeDTO>> listCidadesByEstado(@PathVariable Integer estado_id) {
        List<CidadeDTO> list = cidadeService.findByEstado(estado_id).stream().map(CidadeDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(list);
    }

}
