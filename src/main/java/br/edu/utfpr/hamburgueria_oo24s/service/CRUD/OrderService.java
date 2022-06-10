package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Order;
import br.edu.utfpr.hamburgueria_oo24s.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service @Slf4j @RequiredArgsConstructor
public class OrderService extends CrudService<Order, Long>{

    private final OrderRepository orderRepository;

    @Override
    public JpaRepository getRepository() {
        return orderRepository;
    }

}
