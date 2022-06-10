package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.repository.ItemRepository;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    private ItemService underTest;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        underTest = new ItemService(itemRepository, stockRepository);
    }

    @Test
    @Disabled
    void saveAndUpdateStock() {
    }

    @Test
    void saveItem() {
        //given
        Item item = Item.builder().description("Coca").build();
        ArgumentCaptor<Item> itemArgumentCaptor =
                ArgumentCaptor.forClass(Item.class);

        //when
        underTest.save(item);

        //then
        verify(itemRepository).save(itemArgumentCaptor.capture());

        Item captured = itemArgumentCaptor.getValue();

        assertThat(captured).isEqualTo(item);
    }

    @Test
    void saveItemThatAlreadyExisits() {
        //given
        Item item = Item.builder().description("Coca").build();
        given(itemRepository.existsByDescription("Coca"))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(() -> underTest.save(item))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Item already exists");
    }

}