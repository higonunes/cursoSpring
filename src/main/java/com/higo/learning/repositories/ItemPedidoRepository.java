package com.higo.learning.repositories;

import com.higo.learning.domain.ItemPedido;
import com.higo.learning.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
