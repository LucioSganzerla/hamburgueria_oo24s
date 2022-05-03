package br.edu.utfpr.hamburgueria_oo24s.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
