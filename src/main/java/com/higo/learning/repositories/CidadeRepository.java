package com.higo.learning.repositories;

import com.higo.learning.domain.Categoria;
import com.higo.learning.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
