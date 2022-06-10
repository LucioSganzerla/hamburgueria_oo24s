package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class OrderItem extends Model {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne @Getter
    private Order order;

    @ManyToOne @Getter
    private Item item;

    @Getter
    private Double quantity;

    private LocalDateTime at;

}
