package ru.itm.bkdb.repository.material;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.material.Material;
import ru.itm.bkdb.repository.CommonRepository;
import ru.itm.bkdb.serivce.CommonService;

@Repository
public interface MaterialRepository extends CommonRepository<Material> {
}
