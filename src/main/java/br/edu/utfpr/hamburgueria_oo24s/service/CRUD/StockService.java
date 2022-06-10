package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service @Slf4j @RequiredArgsConstructor
public class StockService extends CrudService<Stock, Long>{

    private final StockRepository stockRepository;

    @Override
    public JpaRepository<Stock, Long> getRepository() {
        return stockRepository;
    }

    public Stock findFirstByItem(Item item) {
        log.info("Fetching stock from {}", item.getDescription());
        return stockRepository.findFirstByItem(item);
    }
}
