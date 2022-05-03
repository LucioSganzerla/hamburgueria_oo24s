package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import br.edu.utfpr.hamburgueria_oo24s.repository.ItemRepository;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor @Slf4j
public record ItemService(ItemRepository repository,
                          StockRepository stockRepository) {

    public Item save(Item item) {
        log.info("Saving item {}", item.getDescription());
        var itemSaved = repository.saveAndFlush(item);
        log.info("Creating stock cell to {}", item.getDescription());
        stockRepository.save(
                Stock.builder()
                        .item(itemSaved)
                        .quantity(0.0).build()
        );
        return itemSaved;
    }

}
