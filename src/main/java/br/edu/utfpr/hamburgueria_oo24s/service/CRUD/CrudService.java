package br.edu.utfpr.hamburgueria_oo24s.service.CRUD;

import br.edu.utfpr.hamburgueria_oo24s.model.Model;
import br.edu.utfpr.hamburgueria_oo24s.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Slf4j
public abstract class CrudService<T extends Model, R> {

    public abstract JpaRepository<T, R> getRepository();

    List<T> findAll() {
        return getRepository().findAll();
    }

    public T save(T object) {
        assert object != null;
        return getRepository().save(object);
    }

    public T getById(R id) {
        return getRepository().getById(id);
    }

    public void delete(T object) {
        getRepository().delete(object);
    }

    public void delete(R id){
        getRepository().deleteById(id);
    }

}
