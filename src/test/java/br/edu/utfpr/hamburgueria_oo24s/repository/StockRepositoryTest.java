package br.edu.utfpr.hamburgueria_oo24s.repository;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StockRepositoryTest {

    @Autowired
    private StockRepository underTest;

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void tearDown() {
        itemRepository.deleteAll();
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStockExistsByItem() {
        // give
        Item item = Item.builder()
                .description("coca")
                .build();
        itemRepository.saveAndFlush(item);

        Stock stock = Stock.builder()
                .item(item)
                .quantity(10.0)
                .build();
        underTest.save(stock);


        // when
        Stock result = underTest.findFirstByItem(item);

        // then
        assertThat(result.getItem().getDescription()).isEqualTo("coca");
    }

    @Test
    void itShouldCheckIfStockNotExistsByItem() {
        // give
        Item item = Item.builder()
                .description("coca")
                .build();
        itemRepository.saveAndFlush(item);

        // when
        Stock result = underTest.findFirstByItem(item);

        // then
        assertThat(result).isNull();
    }
}