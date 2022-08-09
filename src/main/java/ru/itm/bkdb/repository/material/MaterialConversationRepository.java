package ru.itm.bkdb.repository.material;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.material.MaterialConversation;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface MaterialConversationRepository extends CommonRepository<MaterialConversation> {
}
