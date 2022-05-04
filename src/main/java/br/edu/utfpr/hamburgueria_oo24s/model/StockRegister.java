package br.edu.utfpr.hamburgueria_oo24s.model;

import br.edu.utfpr.hamburgueria_oo24s.model.enums.StockRegiserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
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
public class StockRegister {

    @Id @GeneratedValue @Type(type="uuid-char")
    private UUID id;
    @OneToOne @Getter
    private Item item;
    private StockRegiserType type;
    private Double quantity;
    private LocalDateTime at;

}
