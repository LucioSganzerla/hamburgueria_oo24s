package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.StockRegister;
import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockRegisterService;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.edu.utfpr.hamburgueria_oo24s.model.enums.StockRegiserType.*;

@Service @Slf4j
public record BuyItemsService(StockRegisterService stockRegisterService,
                              StockService stockService) {

    public List<ItemQuantityTO> initItemList() {
        return new ArrayList<>();
    }

    public void processShoppingList(List<ItemQuantityTO> products) {
        log.info("Starting process shopping list [...]");
        registerStockMovimentation(products);
        updateStock(products);
        log.info(" [...]Shopping list proccessed");
    }

    private void registerStockMovimentation(List<ItemQuantityTO> products) {
        log.info("Starting registering stock movimentations [...]");
        products.stream()
                .map(product -> StockRegister.builder()
                        .item(product.getItem())
                        .type(ENTRANCE)
                        .quantity(product.getQuantity())
                        .at(LocalDateTime.now())
                        .build())
                .forEach(stockRegisterService::save);
        log.info("[...] Stock movimentations registered ");
    }

    private void updateStock(List<ItemQuantityTO> products) {
        log.info("Starting update stock [...]");
        products.stream()
                .map(product -> stockService.findByItem(product.getItem())
                        .updateIncrementQuantity(product.getQuantity()))
                .forEach(stockService::save);
        log.info("[...] Stock updated");
    }

}
