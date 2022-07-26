package ru.itm.bkdb.repository.act;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.act.Role;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface RoleRepository extends CommonRepository<Role> {
}
