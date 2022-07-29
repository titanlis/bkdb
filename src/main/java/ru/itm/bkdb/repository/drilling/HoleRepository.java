package ru.itm.bkdb.repository.drilling;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.drilling.Hole;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface HoleRepository extends CommonRepository<Hole> {
}
