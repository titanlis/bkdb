package ru.itm.bkdb.repository.material;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.material.MaterialType;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface MaterialTypeRepository extends CommonRepository<MaterialType> {
}
