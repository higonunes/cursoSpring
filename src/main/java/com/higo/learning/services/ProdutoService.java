package com.higo.learning.services;


import com.higo.learning.domain.Categoria;
import com.higo.learning.domain.Cliente;
import com.higo.learning.domain.Produto;
import com.higo.learning.repositories.CategoriaRepository;
import com.higo.learning.repositories.ProdutoRepository;
import com.higo.learning.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto buscar(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.fromString(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.search(nome, categorias, pageRequest);
    }
}
