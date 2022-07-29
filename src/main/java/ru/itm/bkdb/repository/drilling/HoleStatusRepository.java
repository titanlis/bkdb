package ru.itm.bkdb.repository.drilling;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.drilling.HoleStatus;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface HoleStatusRepository extends CommonRepository<HoleStatus> {
}
