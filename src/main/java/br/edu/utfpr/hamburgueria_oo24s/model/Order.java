package br.edu.utfpr.hamburgueria_oo24s.model;

import br.edu.utfpr.hamburgueria_oo24s.model.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static br.edu.utfpr.hamburgueria_oo24s.model.enums.OrderStatus.*;
import static javax.persistence.GenerationType.*;

@Entity
@NoArgsConstructor
@Table(name = "my_order")
public class Order extends Model{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private Long id;

    private LocalDateTime date;

    @OneToMany(mappedBy = "order")
    @Getter
    private List<OrderItem> itens;

    @Setter
    private OrderStatus status;

    @ManyToOne
    private Waiter waiter;

    public Order(Waiter waiter) {
        this.waiter = waiter;
        this.date = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.status = OPENED;
    }
}