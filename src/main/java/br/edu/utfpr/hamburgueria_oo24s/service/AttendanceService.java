package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Order;
import br.edu.utfpr.hamburgueria_oo24s.model.OrderItem;
import br.edu.utfpr.hamburgueria_oo24s.model.Waiter;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.OrderItemService;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.OrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record AttendanceService(OrderService orderService,
                                OrderItemService orderItemService) {

    public Order startNewOrder(Waiter waiter) {
        Order order = new Order(waiter);
        return orderService.save(order);
    }

    public void addItemToOrder(Order order, Item item, Double quantity) {
        log.info("Add item {} to order {}", item.getDescription(), order.getId());
        order.getItens().add(createOrderItem(order, item, quantity));
        orderService.save(order);
    }

    private OrderItem createOrderItem(Order order, Item item, Double quantity) {
        log.info("creating orderItem to order {}, item {}",
                order.getId(), item.getDescription());
        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .item(item)
                .quantity(quantity)
                .build();
        orderItemService.save(orderItem);
        return orderItem;
    }


}
