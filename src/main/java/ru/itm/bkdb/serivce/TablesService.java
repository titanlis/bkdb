package ru.itm.bkdb.serivce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itm.bkdb.entity.TableVersion;
import ru.itm.bkdb.repository.TableRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TablesService {

    private static Logger logger = LoggerFactory.getLogger(TablesService.class);

    @Autowired
    private final TableRepository tableRepository;

    public TablesService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }
    public List<TableVersion> findAll(){
        return tableRepository.findAll();
    }
    public void save(TableVersion entity){ tableRepository.save(entity); }

}
