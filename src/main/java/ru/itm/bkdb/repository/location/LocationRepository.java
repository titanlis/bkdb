package ru.itm.bkdb.repository.location;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.location.Location;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface LocationRepository extends CommonRepository<Location> {
}

