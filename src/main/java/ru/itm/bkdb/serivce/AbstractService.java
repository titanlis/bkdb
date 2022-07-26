package ru.itm.bkdb.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.repository.CommonRepository;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

//другие методы, переопределённые из интерфейса
}