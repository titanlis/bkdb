package ru.itm.bkdb.serivce.act;

import org.springframework.stereotype.Service;
import ru.itm.bkdb.entity.tables.operator.Act;
import ru.itm.bkdb.repository.operator.ActRepository;
import ru.itm.bkdb.serivce.AbstractService;


@Service
public class ActService extends AbstractService<Act, ActRepository> {
    public ActService(ActRepository repository) {
        super(repository);
    }
}