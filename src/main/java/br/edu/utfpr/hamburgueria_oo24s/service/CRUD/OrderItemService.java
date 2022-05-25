package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.OrderItem;
import br.edu.utfpr.hamburgueria_oo24s.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service @Slf4j @RequiredArgsConstructor
public class OrderItemService extends CrudService<OrderItem, Long> {

    private final OrderItemRepository repository;

    @Override
    public JpaRepository<OrderItem, Long> getRepository() {
        return repository;
    }

}
