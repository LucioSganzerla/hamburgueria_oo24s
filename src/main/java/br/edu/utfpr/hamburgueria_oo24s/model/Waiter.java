package br.edu.utfpr.hamburgueria_oo24s.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Waiter extends Model{

    @Id @GeneratedValue @Type(type = "uuid-char")
    private UUID uuid;

    private String name;
}
