package ru.itm.bkdb.repository.dispatcher;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.dispatcher.Dispatcher;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface DispatcherRepository extends CommonRepository<Dispatcher> {
}
