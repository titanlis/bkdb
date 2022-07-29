package ru.itm.bkdb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.itm.bkdb.repository.config.ValuesDataRepository;
import ru.itm.bkdb.repository.dispatcher.DispatcherRepository;
import ru.itm.bkdb.repository.drilling.HoleRepository;
import ru.itm.bkdb.repository.drilling.HoleStatusRepository;
import ru.itm.bkdb.repository.location.LocationRepository;
import ru.itm.bkdb.repository.operator.ActRepository;
import ru.itm.bkdb.repository.operator.ActToRoleRepository;
import ru.itm.bkdb.repository.operator.RoleRepository;

@Component
public class RepositoryFactory {
    private static ActRepository actRepository;
    private static ActToRoleRepository actToRoleRepository;
    private static RoleRepository roleRepository;
    private static ValuesDataRepository valuesDataRepository;
    private static DispatcherRepository dispatcherRepository;
    private static HoleRepository holeRepository;
    private static HoleStatusRepository holeStatusRepository;
    private static LocationRepository locationRepository;

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Autowired
    public void setHoleRepository(HoleRepository holeRepository) {
        this.holeRepository = holeRepository;
    }

    @Autowired
    public void setHoleStatusRepository(HoleStatusRepository holeStatusRepository) {
        this.holeStatusRepository = holeStatusRepository;
    }

    @Autowired
    public void setActRepository(ru.itm.bkdb.repository.operator.ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    @Autowired
    public void setActRepository(ActToRoleRepository actToRoleRepository) {
        this.actToRoleRepository = actToRoleRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setValuesDataRepository(ValuesDataRepository valuesDataRepository) {
        this.valuesDataRepository = valuesDataRepository;
    }

    @Autowired
    public void setDispatcherRepository(DispatcherRepository dispatcherRepository) {
        this.dispatcherRepository = dispatcherRepository;
    }

    public static CommonRepository getRepo(String tableName){
        switch (tableName.toLowerCase()){

            case "acts" -> {
                return actRepository;
            }
            case "acts_to_roles" -> {
                return actToRoleRepository;
            }
            case "roles" -> {
                return roleRepository;
            }
            case "values_data" -> {
                return valuesDataRepository;
            }
            case "dispatcher" -> {
                return dispatcherRepository;
            }
            case "location" -> {
                return locationRepository;
            }
            case "holes" -> {
                return holeRepository;
            }
            default -> { return null; }
        }
    }

}
