package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.GenerationType.*;

@Entity
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class Item {

    @Id @GeneratedValue(strategy = AUTO) @Type(type = "uuid-char")
    private UUID id;

    @Column(unique = true)
    private String description;

    @Column(precision = 2)
    private Double value;
}
