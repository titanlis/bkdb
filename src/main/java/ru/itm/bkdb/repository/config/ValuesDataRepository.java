package ru.itm.bkdb.repository.config;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.config.ValuesData;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface ValuesDataRepository  extends CommonRepository<ValuesData> {
}
