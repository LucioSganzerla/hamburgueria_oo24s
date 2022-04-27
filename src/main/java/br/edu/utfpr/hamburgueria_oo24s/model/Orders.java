package br.edu.utfpr.hamburgueria_oo24s.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}
