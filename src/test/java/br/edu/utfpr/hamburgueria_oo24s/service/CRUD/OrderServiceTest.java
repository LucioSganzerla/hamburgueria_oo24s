package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Order;
import br.edu.utfpr.hamburgueria_oo24s.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    private OrderService underTest;
    @Mock private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        underTest = new OrderService(orderRepository);
    }

    @Test
    void testFindAll() {
        //when
        underTest.findAll();

        //then
        verify(orderRepository).findAll();
    }

    @Test
    void saveOrder() {
        //given
        Order order = new Order();
        ArgumentCaptor<Order> orderArgumentCaptor =
                ArgumentCaptor.forClass(Order.class);

        //when
        underTest.save(order);

        //then
        verify(orderRepository).save(orderArgumentCaptor.capture());

        Order captured = orderArgumentCaptor.getValue();

        assertThat(captured).isEqualTo(order);

    }
}