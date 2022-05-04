package br.edu.utfpr.hamburgueria_oo24s.model.dto;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import lombok.Getter;

@Getter
public class ItemQuantityTO {
    private Item item;
    private Double quantity;
}
