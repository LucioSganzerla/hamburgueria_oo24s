package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import br.edu.utfpr.hamburgueria_oo24s.repository.ItemRepository;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @Slf4j @RequiredArgsConstructor
public class ItemService extends CrudService<Item, UUID> {

    private final ItemRepository repository;
    private final StockRepository stockRepository;

    @Override
    public ItemRepository getRepository() {
        return repository;
    }

    public Item saveAndUpdateStock(Item item) {
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
