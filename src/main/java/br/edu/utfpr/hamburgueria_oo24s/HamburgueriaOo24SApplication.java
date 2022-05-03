package br.edu.utfpr.hamburgueria_oo24s;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.model.dto.ItemQuantityTO;
import br.edu.utfpr.hamburgueria_oo24s.service.BuyProductsService;
import br.edu.utfpr.hamburgueria_oo24s.service.CRUD.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class HamburgueriaOo24SApplication {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BuyProductsService buyProductsService;

    public static void main(String[] args) {
        SpringApplication.run(HamburgueriaOo24SApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        var coke = itemService.save(
                Item.builder()
                        .description("Coke")
                        .value(4.5)
                        .build()
        );



        buyProductsService.processBuyList(List.of(
                new ItemQuantityTO(coke, 10.0)
        ));
    }

}
