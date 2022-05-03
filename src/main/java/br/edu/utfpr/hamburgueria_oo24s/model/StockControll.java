package br.edu.utfpr.hamburgueria_oo24s.model;

import br.edu.utfpr.hamburgueria_oo24s.model.enums.StockMovimentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
public class StockControll {

    @Id @GeneratedValue @Type(type = "uuid-char")
    private UUID id;
    @OneToOne
    private Item item;
    private StockMovimentType type;
    private LocalDateTime at;
    private Double quantity;

}
