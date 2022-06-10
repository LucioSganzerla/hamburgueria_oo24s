package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Order;
import br.edu.utfpr.hamburgueria_oo24s.model.OrderItem;
import br.edu.utfpr.hamburgueria_oo24s.model.enums.OrderStatus;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.OrderService;

import java.math.BigDecimal;

public record CloseOrderService(OrderService service, RemoveFromStockService removeFromStockService) {

    public BigDecimal closeOrder(Order order) {
        order.setStatus(OrderStatus.FINALIZED);
        service.save(order);
        removeFromStockService.removeFromStock(order.getItens());
        return order.getItens()
                .stream()
                .map(OrderItem::getItem)
                .map(Item::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
