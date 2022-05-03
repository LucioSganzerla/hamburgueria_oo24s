package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor @Slf4j
public record StockService(StockRepository stockRepository) {

    public Stock findFirstByItem(Item item) {
        log.info("Fetching stock from {}", item.getDescription());
        return stockRepository.findFirstByItem(item);
    }

    public void save(Stock stock) {
        assert stock.getItem() != null;
        log.info("Saving stock from {}", stock.getItem().getDescription());
        stockRepository.save(stock);
    }
}
