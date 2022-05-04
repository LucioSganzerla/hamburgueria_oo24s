package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Item;
import br.edu.utfpr.hamburgueria_oo24s.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
public record ItemService( ItemRepository repository) {

    public void salvar(Item item) {
        log.info("saving item {}", item.getDescription());
        repository.save(item);
    }

}
