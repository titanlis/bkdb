package ru.itm.bkdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itm.bkdb.entity.TableVersion;

/** Интерфейс доступа к бд*/
public interface TableRepository extends JpaRepository<TableVersion, Long> { }