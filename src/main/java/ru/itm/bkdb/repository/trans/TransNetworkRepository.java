package ru.itm.bkdb.repository.trans;

import org.springframework.stereotype.Repository;
import ru.itm.bkdb.entity.tables.trans.TransNetwork;
import ru.itm.bkdb.repository.CommonRepository;

@Repository
public interface TransNetworkRepository   extends CommonRepository<TransNetwork> { }
