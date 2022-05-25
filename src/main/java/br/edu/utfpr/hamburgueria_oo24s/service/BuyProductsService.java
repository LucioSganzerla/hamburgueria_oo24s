package br.edu.utfpr.hamburgueria_oo24s.service;

import br.edu.utfpr.hamburgueria_oo24s.model.StockControll;
import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockControllRepository;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.edu.utfpr.hamburgueria_oo24s.model.enums.StockMovimentType.*;

@Service
@Slf4j
public record BuyProductsService(StockControllRepository stockControllRepository,
                                 StockService stockService) {

    public List<ItemQuantityTO> initProductsList() {
        log.info("Creating new ItemQuantityTO list");
        return new ArrayList<>();
    }

    public void processBuyList(List<ItemQuantityTO> products) {
        log.info("Start processing bought list [...]");
        saveStockControll(products);
        updateStock(products);
        log.info("[...] bought list processed");
    }

    private void saveStockControll(List<ItemQuantityTO> products) {
        log.info("Start saving stockControll from list [...]");
        stockControllRepository.saveAll(
                products.stream()
                        .map(product -> StockControll.builder()
                                .item(product.getItem())
                                .type(ENTRANCE)
                                .quantity(product.getQuantity())
                                .at(LocalDateTime.now())
                                .build()).toList());
        log.info("[...] stock controll saved");
    }

    private void updateStock(List<ItemQuantityTO> products) {
        log.info("Starting updating stock from list [...]");
        products.stream()
                .map(product -> stockService.findFirstByItem(product.getItem())
                        .updateBy(product)
                )
                .forEach(stockService::save);
        log.info("[...] stock updated");
    }
}
