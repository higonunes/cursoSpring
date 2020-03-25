package com.higo.learning.repositories;

import com.higo.learning.domain.Pagamento;
import com.higo.learning.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
