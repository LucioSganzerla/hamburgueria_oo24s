package br.edu.utfpr.hamburgueria_oo24s.repository;

import br.edu.utfpr.hamburgueria_oo24s.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
