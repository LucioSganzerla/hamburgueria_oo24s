package br.edu.utfpr.hamburgueria_oo24s.repository;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository underTest;

    @Test
    void checkIfExistsByDescription() {
        // given
        Item item = Item.builder()
                .description("Coca")
                .build();
        underTest.save(item);

        // when
        Boolean result = underTest.existsByDescription("Coca");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void checkIfNotExistsByDescription() {
        // given
        Item item = Item.builder()
                .description("Coca")
                .build();
        underTest.save(item);

        // when
        Boolean result = underTest.existsByDescription("pepsi");

        // then
        assertThat(result).isFalse();
    }

}