package ru.itm.bkdb.serivce.act;

import org.springframework.stereotype.Service;
import ru.itm.bkdb.entity.tables.act.Act;
import ru.itm.bkdb.repository.act.ActRepository;
import ru.itm.bkdb.serivce.AbstractService;


@Service
public class ActService extends AbstractService<Act, ActRepository> {
    public ActService(ActRepository repository) {
        super(repository);
    }
}