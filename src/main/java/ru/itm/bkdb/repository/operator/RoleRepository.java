package ru.itm.bkdb.repository.operator;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.operator.Role;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface RoleRepository extends CommonRepository<Role> {
}
