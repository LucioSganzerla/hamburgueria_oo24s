package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.StockRegister;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockRegisterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record StockRegisterService(StockRegisterRepository repository) {

    public StockRegister save(StockRegister stockRegister){
        log.info("Saving stock movimentation from item {}",
                stockRegister.getItem().getDescription());
        return repository.save(stockRegister);
    }

}
