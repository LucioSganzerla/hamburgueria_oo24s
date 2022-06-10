package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.OrderItem;
import br.edu.utfpr.hamburgueria_oo24s.model.StockControll;
import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockControllRepository;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockService;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

import static br.edu.utfpr.hamburgueria_oo24s.model.enums.StockMovimentType.DEPARTURE;

@Slf4j
public record RemoveFromStockService(StockControllRepository stockControllRepository,
                                     StockService stockService) {

    public void removeFromStock(List<OrderItem> itens){
        List<ItemQuantityTO> products = itens
                .stream()
                .map(orderItem -> new ItemQuantityTO(orderItem.getItem(), orderItem.getQuantity()))
                .toList();
        saveStockControl(products);
        updateStock(products);
    }

    private void updateStock(List<ItemQuantityTO> products) {
        products.stream()
                .map(product -> StockControll.builder()
                        .item(product.getItem())
                        .type(DEPARTURE)
                        .quantity(product.getQuantity())
                        .at(LocalDateTime.now())
                        .build())
                .forEach(stockControllRepository::save);
    }

    private void saveStockControl(List<ItemQuantityTO> products) {
        log.info("Starting updating stock from list [...]");
        products.stream()
                .map(product -> stockService.findFirstByItem(product.getItem())
                        .updateBy(product))
                .forEach(stockService::save);
        log.info("[...] stock updated");
    }
}
