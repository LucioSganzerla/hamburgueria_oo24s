package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.StockControll;
import br.edu.utfpr.hamburgueria_oo24s.repository.StockControllRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class StockControllService extends CrudService<StockControll, UUID >{

    private final StockControllRepository repository;

    @Override
    public JpaRepository<StockControll, UUID> getRepository() {
        return repository;
    }
}
