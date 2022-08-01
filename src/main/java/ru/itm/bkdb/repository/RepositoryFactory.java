package ru.itm.bkdb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.itm.bkdb.repository.config.ValuesDataRepository;
import ru.itm.bkdb.repository.dispatcher.DispatcherRepository;
import ru.itm.bkdb.repository.drilling.HoleRepository;
import ru.itm.bkdb.repository.drilling.HoleStatusRepository;
import ru.itm.bkdb.repository.equipment.*;
import ru.itm.bkdb.repository.lis.*;
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
    private static EquipmentRepository equipmentRepository;
    private static LocationRepository locationRepository;
    private static EquipmentDrillRepository equipmentDrillRepository;
    private static EquipmentHaulRepository equipmentHaulRepository;
    private static EquipmentLoadRepository equipmentLoadRepository;
    private static EquipmentTypeRepository equipmentTypeRepository;
    private static ActionGroupRepository actionGroupRepository;
    private static ActionVariableSourceRepository actionVariableSourceRepository;
    private static LisActionRepository lisActionRepository;
    private static LisActionPredicateRepository lisActionPredicateRepository;
    private static LisActionPredicateVaribleRepository lisActionPredicateVaribleRepository;
    private static LisActionSourceVariableRepository lisActionSourceVariableRepository;

    @Autowired
    public void setLisActionSourceVariableRepository(LisActionSourceVariableRepository lisActionSourceVariableRepository) {
        RepositoryFactory.lisActionSourceVariableRepository = lisActionSourceVariableRepository;
    }

    @Autowired
    public void setLisActionPredicateVariableRepository(LisActionPredicateVaribleRepository lisActionPredicateVaribleRepository) {
        RepositoryFactory.lisActionPredicateVaribleRepository = lisActionPredicateVaribleRepository;
    }

    @Autowired
    public void setLisActionPredicateRepository(LisActionPredicateRepository lisActionPredicateRepository) {
        RepositoryFactory.lisActionPredicateRepository = lisActionPredicateRepository;
    }

    @Autowired
    public void setLisActionRepository(LisActionRepository lisActionRepository) {
        RepositoryFactory.lisActionRepository = lisActionRepository;
    }

    @Autowired
    public void setActionVariableSourceRepository(ActionVariableSourceRepository actionVariableSourceRepository) {
        RepositoryFactory.actionVariableSourceRepository = actionVariableSourceRepository;
    }

    @Autowired
    public void setActionGroupRepository(ActionGroupRepository actionGroupRepository) {
        RepositoryFactory.actionGroupRepository = actionGroupRepository;
    }

    @Autowired
    public void setEquipmentTypeRepository(EquipmentTypeRepository equipmentTypeRepository) {
        RepositoryFactory.equipmentTypeRepository = equipmentTypeRepository;
    }

    @Autowired
    public void setEquipmentLoadRepository(EquipmentLoadRepository equipmentLoadRepository) {
        RepositoryFactory.equipmentLoadRepository = equipmentLoadRepository;
    }

    @Autowired
    public void setEquipmentHaulRepository(EquipmentHaulRepository equipmentHaulRepository) {
        RepositoryFactory.equipmentHaulRepository = equipmentHaulRepository;
    }

    @Autowired
    public void setEquipmentDrillRepository(EquipmentDrillRepository equipmentDrillRepository) {
        RepositoryFactory.equipmentDrillRepository = equipmentDrillRepository;
    }

    @Autowired
    public void setActRepository(ActRepository actRepository) {
        RepositoryFactory.actRepository = actRepository;
    }

    @Autowired
    public void setActToRoleRepository(ActToRoleRepository actToRoleRepository) {
        RepositoryFactory.actToRoleRepository = actToRoleRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        RepositoryFactory.roleRepository = roleRepository;
    }

    @Autowired
    public void setValuesDataRepository(ValuesDataRepository valuesDataRepository) {
        RepositoryFactory.valuesDataRepository = valuesDataRepository;
    }

    @Autowired
    public void setDispatcherRepository(DispatcherRepository dispatcherRepository) {
        RepositoryFactory.dispatcherRepository = dispatcherRepository;
    }

    @Autowired
    public void setHoleRepository(HoleRepository holeRepository) {
        RepositoryFactory.holeRepository = holeRepository;
    }

    @Autowired
    public void setHoleStatusRepository(HoleStatusRepository holeStatusRepository) {
        RepositoryFactory.holeStatusRepository = holeStatusRepository;
    }

    @Autowired
    public void setEquipmentRepository(EquipmentRepository equipmentRepository) {
        RepositoryFactory.equipmentRepository = equipmentRepository;
    }

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        RepositoryFactory.locationRepository = locationRepository;
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
            case "hole_status" -> {
                return holeStatusRepository;
            }
            case "equipment" -> {
                return equipmentRepository;
            }
            case "equipment_drill" -> {
                return equipmentDrillRepository;
            }
            case "equipment_haul" -> {
                return equipmentHaulRepository;
            }
            case "equipment_load" -> {
                return equipmentLoadRepository;
            }
            case "equip_type" -> {
                return equipmentTypeRepository;
            }
            case "action_group" -> {
                return actionGroupRepository;
            }
            case "action_variable_source" -> {
                return actionVariableSourceRepository;
            }
            case "lis_action" -> {
                return lisActionRepository;
            }
            case "lis_action_predicate" -> {
                return lisActionPredicateRepository;
            }
            case "lis_action_predicate_varible" -> {
                return lisActionPredicateVaribleRepository;
            }
            case "lis_action_source_varible" -> {
                return lisActionSourceVariableRepository;
            }

            default -> { return null; }
        }
    }

}
