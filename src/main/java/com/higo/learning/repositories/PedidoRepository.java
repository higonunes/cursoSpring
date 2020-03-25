package com.higo.learning.repositories;

import com.higo.learning.domain.Pedido;
import com.higo.learning.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
