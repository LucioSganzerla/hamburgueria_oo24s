package br.edu.utfpr.hamburgueria_oo24s.model.dto;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ItemQuantityTO {
    private Item item;
    private Double quantity;
}
