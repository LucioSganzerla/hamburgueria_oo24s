package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Stock {

    @Id @GeneratedValue
    private Long id;
    @OneToOne @Getter
    private Item item;
    private Double quantity;
    //@LastModifiedDate
    private LocalDateTime lastTransaction;

    public Stock updateIncrementQuantity(Double quantity){
        this.quantity += quantity;
        this.lastTransaction = LocalDateTime.now();
        return this;
    }

}
