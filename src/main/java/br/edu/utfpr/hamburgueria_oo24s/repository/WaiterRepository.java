package br.edu.utfpr.hamburgueria_oo24s.repository;

import br.edu.utfpr.hamburgueria_oo24s.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, Long> {
}
