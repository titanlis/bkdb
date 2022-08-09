package ru.itm.bkdb.repository.status;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.status.StatusCatLocationRel;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface StatusCatLocationRelRepository extends CommonRepository<StatusCatLocationRel> {
}
