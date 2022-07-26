package ru.itm.bkdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itm.bkdb.entity.AbstractEntity;
import ru.itm.bkdb.serivce.CommonService;


public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

//    @Override
//    public ResponseEntity<E> save(@RequestBody E entity) {
//        return service.save(entity).map(ResponseEntity::ok)
//                .orElseThrow(() -> new SampleException(
//                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), entity.toString())
//                ));
//    }

//другие методы
}