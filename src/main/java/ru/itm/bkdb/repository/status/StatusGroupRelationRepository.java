package ru.itm.bkdb.repository.status;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.status.StatusGroupRelation;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface StatusGroupRelationRepository extends CommonRepository<StatusGroupRelation> {
}
