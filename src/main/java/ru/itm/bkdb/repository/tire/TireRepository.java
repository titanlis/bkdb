package ru.itm.bkdb.repository.tire;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.tire.Tire;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface TireRepository extends CommonRepository<Tire> {
}
