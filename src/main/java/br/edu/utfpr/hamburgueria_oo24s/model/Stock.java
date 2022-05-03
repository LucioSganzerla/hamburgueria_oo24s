package br.edu.utfpr.hamburgueria_oo24s.model;

import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @AllArgsConstructor @RequiredArgsConstructor @Builder
public class Stock {

    @Id @GeneratedValue
    private Long id;
    @OneToOne @Getter
    private Item item;
    private Double quantity;
    private LocalDateTime lastModified;

    public Stock updateBy(ItemQuantityTO to){
        this.quantity += to.getQuantity();
        this.lastModified = LocalDateTime.now();
        return this;
    }

}
