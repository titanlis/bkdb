package ru.itm.bkdb.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.itm.bkdb.repository.config.ValuesDataRepository;
import ru.itm.bkdb.repository.dispatcher.DispatcherRepository;
import ru.itm.bkdb.repository.drilling.HoleRepository;
import ru.itm.bkdb.repository.drilling.HoleStatusRepository;
import ru.itm.bkdb.repository.equipment.*;
import ru.itm.bkdb.repository.lis.*;
import ru.itm.bkdb.repository.location.*;
import ru.itm.bkdb.repository.material.MaterialConversationRepository;
import ru.itm.bkdb.repository.material.MaterialRepository;
import ru.itm.bkdb.repository.material.MaterialTypeRepository;
import ru.itm.bkdb.repository.operator.*;
import ru.itm.bkdb.repository.sensor.SensorDataTypeRepository;
import ru.itm.bkdb.repository.sensor.SensorInclineCalibrationRepository;
import ru.itm.bkdb.repository.sensor.SensorRepository;
import ru.itm.bkdb.repository.sensor.SensorTypeRepository;
import ru.itm.bkdb.repository.shift.ShiftRepository;
import ru.itm.bkdb.repository.status.*;

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
    private static LisActionPredicateVariableRepository lisActionPredicateVariableRepository;
    private static LisActionSourceVariableRepository lisActionSourceVariableRepository;
    private static LisPredicateRepository lisPredicateRepository;
    private static LisSourceVariableRepository lisSourceVariableRepository;
    private static LisTypeRepository lisTypeRepository;
    private static LisActionVariableRepository lisActionVariableRepository;
    private static LisConnectionRepository lisConnectionRepository;
    private static LisPredicateVariableRepository lisPredicateVariableRepository;
    private static LisGroupRepository lisGroupRepository;
    private static LisPointRepository lisPointRepository;
    private static LisCheckFunctionRepository lisCheckFunctionRepository;
    private static CoordinateLocationRepository coordinateLocationRepository;
    private static LocationAutoStatusRepository locationAutoStatusRepository;
    private static LocationInheritanceRepository locationInheritanceRepository;
    private static LocationTypeRepository locationTypeRepository;
    private static RoadRepository roadRepository;
    private static SpeedLimitsRepository speedLimitsRepository;
    private static MaterialTypeRepository materialTypeRepository;
    private static MaterialConversationRepository materialConversationRepository;
    private static MaterialRepository materialRepository;
    private static OperatorRepository operatorRepository;
    private static OperatorOnEquipRepository operatorOnEquipRepository;
    private static OperatorOnEquipTypeRepository operatorOnEquipTypeRepository;

    private static SensorTypeRepository sensorTypeRepository;
    private static SensorInclineCalibrationRepository sensorInclineCalibrationRepository;
    private static SensorDataTypeRepository sensorDataTypeRepository;
    private static SensorRepository sensorRepository;
    private static ShiftRepository shiftRepository;
    private static StatusesRepository statusesRepository;
    private static StatusCategoryRepository statusCategoryRepository;
    private static StatusCatLocationRelRepository statusCatLocationRelRepository;
    private static StatusGroupRepository statusGroupRepository;
    private static StatusGroupRelationRepository statusGroupRelationRepository;
    private static StatusInheritanceRepository statusInheritanceRepository;
    private static RoutesRepository routesRepository;
    private static RoutesRoadsRepository routesRoadsRepository;

    @Autowired
    public void setRoutesRoadsRepository(RoutesRoadsRepository routesRoadsRepository) {
        RepositoryFactory.routesRoadsRepository = routesRoadsRepository;
    }

    @Autowired
    public void setRoutesRepository(RoutesRepository routesRepository) {
        RepositoryFactory.routesRepository = routesRepository;
    }
    @Autowired
    public void setStatusInheritanceRepository(StatusInheritanceRepository statusInheritanceRepository) {
        RepositoryFactory.statusInheritanceRepository = statusInheritanceRepository;
    }

    @Autowired
    public void setStatusGroupRelationRepository(StatusGroupRelationRepository statusGroupRelationRepository) {
        RepositoryFactory.statusGroupRelationRepository = statusGroupRelationRepository;
    }

    @Autowired
    public void setStatusGroupRepository(StatusGroupRepository statusGroupRepository) {
        RepositoryFactory.statusGroupRepository = statusGroupRepository;
    }

    @Autowired
    public void setStatusCatLocationRelRepository(StatusCatLocationRelRepository statusCatLocationRelRepository) {
        RepositoryFactory.statusCatLocationRelRepository = statusCatLocationRelRepository;
    }

    @Autowired
    public void setStatusCategoryRepository(StatusCategoryRepository statusCategoryRepository) {
        RepositoryFactory.statusCategoryRepository = statusCategoryRepository;
    }

    @Autowired
    public void setStatusesRepository(StatusesRepository statusesRepository) {
        RepositoryFactory.statusesRepository = statusesRepository;
    }

    @Autowired
    public void setShiftRepository(ShiftRepository shiftRepository) {
        RepositoryFactory.shiftRepository = shiftRepository;
    }

    @Autowired
    public void setSensorRepository(SensorRepository sensorRepository) {
        RepositoryFactory.sensorRepository = sensorRepository;
    }

    @Autowired
    public void setSensorDataTypeRepository(SensorDataTypeRepository sensorDataTypeRepository) {
        RepositoryFactory.sensorDataTypeRepository = sensorDataTypeRepository;
    }

    @Autowired
    public void setSensorInclineCalibrationRepository(SensorInclineCalibrationRepository sensorInclineCalibrationRepository) {
        RepositoryFactory.sensorInclineCalibrationRepository = sensorInclineCalibrationRepository;
    }

    @Autowired
    public void setSensorTypeRepository(SensorTypeRepository sensorTypeRepository) {
        RepositoryFactory.sensorTypeRepository = sensorTypeRepository;
    }

    @Autowired
    public void setOperatorOnEquipTypeRepository(OperatorOnEquipTypeRepository operatorOnEquipTypeRepository) {
        RepositoryFactory.operatorOnEquipTypeRepository = operatorOnEquipTypeRepository;
    }

    @Autowired
    public void setOperatorOnEquipRepository(OperatorOnEquipRepository operatorOnEquipRepository) {
        RepositoryFactory.operatorOnEquipRepository = operatorOnEquipRepository;
    }

    @Autowired
    public void setOperatorRepository(OperatorRepository operatorRepository) {
        RepositoryFactory.operatorRepository = operatorRepository;
    }

    @Autowired
    public void setMaterialRepository(MaterialRepository materialRepository) {
        RepositoryFactory.materialRepository = materialRepository;
    }

    @Autowired
    public void setMaterialConversationRepository(MaterialConversationRepository materialConversationRepository) {
        RepositoryFactory.materialConversationRepository = materialConversationRepository;
    }
    @Autowired
    public void setMaterialTypeRepository(MaterialTypeRepository materialTypeRepository) {
        RepositoryFactory.materialTypeRepository = materialTypeRepository;
    }

    @Autowired
    public void setSpeedLimitsRepository(SpeedLimitsRepository speedLimitsRepository) {
        RepositoryFactory.speedLimitsRepository = speedLimitsRepository;
    }

    @Autowired
    public void setRoadRepository(RoadRepository roadRepository) {
        RepositoryFactory.roadRepository = roadRepository;
    }
    @Autowired
    public void setLocationTypeRepository(LocationTypeRepository locationTypeRepository) {
        RepositoryFactory.locationTypeRepository = locationTypeRepository;
    }
    @Autowired
    public void setLocationInheritanceRepository(LocationInheritanceRepository locationInheritanceRepository) {
        RepositoryFactory.locationInheritanceRepository = locationInheritanceRepository;
    }

    @Autowired
    public void setLocationAutoStatusRepository(LocationAutoStatusRepository locationAutoStatusRepository) {
        RepositoryFactory.locationAutoStatusRepository = locationAutoStatusRepository;
    }
    @Autowired
    public void setCoordinateLocationRepository(CoordinateLocationRepository coordinateLocationRepository) {
        RepositoryFactory.coordinateLocationRepository = coordinateLocationRepository;
    }

    @Autowired
    public void setLisCheckFunctionRepository(LisCheckFunctionRepository lisCheckFunctionRepository) {
        RepositoryFactory.lisCheckFunctionRepository = lisCheckFunctionRepository;
    }

    @Autowired
    public void setLisPointRepository(LisPointRepository lisPointRepository) {
        RepositoryFactory.lisPointRepository = lisPointRepository;
    }

    @Autowired
    public void setLisGroupRepository(LisGroupRepository lisGroupRepository) {
        RepositoryFactory.lisGroupRepository = lisGroupRepository;
    }
    @Autowired
    public void setLisPredicateVariableRepository(LisPredicateVariableRepository lisPredicateVariableRepository) {
        RepositoryFactory.lisPredicateVariableRepository = lisPredicateVariableRepository;
    }

    @Autowired
    public void setLisConnectionRepository(LisConnectionRepository lisConnectionRepository) {
        RepositoryFactory.lisConnectionRepository = lisConnectionRepository;
    }

    @Autowired
    public void setLisActionVariableRepository(LisActionVariableRepository lisActionVariableRepository) {
        RepositoryFactory.lisActionVariableRepository = lisActionVariableRepository;
    }

    @Autowired
    public void setLisTypeRepository(LisTypeRepository lisTypeRepository) {
        RepositoryFactory.lisTypeRepository = lisTypeRepository;
    }

    @Autowired
    public void setLisSourceVariableRepository(LisSourceVariableRepository lisSourceVariableRepository) {
        RepositoryFactory.lisSourceVariableRepository = lisSourceVariableRepository;
    }

    @Autowired
    public void setLisPredicateRepository(LisPredicateRepository lisPredicateRepository) {
        RepositoryFactory.lisPredicateRepository = lisPredicateRepository;
    }

    @Autowired
    public void setLisActionSourceVariableRepository(LisActionSourceVariableRepository lisActionSourceVariableRepository) {
        RepositoryFactory.lisActionSourceVariableRepository = lisActionSourceVariableRepository;
    }

    @Autowired
    public void setLisActionPredicateVariableRepository(LisActionPredicateVariableRepository lisActionPredicateVariableRepository) {
        RepositoryFactory.lisActionPredicateVariableRepository = lisActionPredicateVariableRepository;
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

        return switch (tableName.toLowerCase()){
            case "acts"          -> actRepository;
            case "acts_to_roles" -> actToRoleRepository;
            case "roles"         -> roleRepository;
            case "values_data"   -> valuesDataRepository;
            case "dispatcher"    -> dispatcherRepository;
            case "holes"         -> holeRepository;
            case "hole_status"   -> holeStatusRepository;
            case "equipment"     -> equipmentRepository;
            case "equipment_drill" -> equipmentDrillRepository;
            case "equipment_haul"  -> equipmentHaulRepository;
            case "equipment_load"  -> equipmentLoadRepository;
            case "equip_type"      -> equipmentTypeRepository;
            case "action_group"    -> actionGroupRepository;
            case "action_variable_source" -> actionVariableSourceRepository;
            case "lis_action"      -> lisActionRepository;
            case "lis_action_predicate" -> lisActionPredicateRepository;
            case "lis_action_predicate_variable" -> lisActionPredicateVariableRepository;
            case "lis_action_source_variable" -> lisActionSourceVariableRepository;
            case "lis_predicate"          -> lisPredicateRepository;
            case "lis_source_variable"    -> lisSourceVariableRepository;
            case "lis_type"               -> lisTypeRepository;
            case "lis_action_variable"    -> lisActionVariableRepository;
            case "lis_connection"         -> lisConnectionRepository;
            case "lis_predicate_variable" -> lisPredicateVariableRepository;
            case "lis_group" -> lisGroupRepository;
            case "lis_point" -> lisPointRepository;
            case "lis_check_function" -> lisCheckFunctionRepository;
            case "coord_loc" -> coordinateLocationRepository;
            case "location" -> locationRepository;
            case "location_auto_status" -> locationAutoStatusRepository;
            case "loc_inheritance" -> locationInheritanceRepository;
            case "location_type" -> locationTypeRepository;
            case "roads" -> roadRepository;
            case "speed_limits" -> speedLimitsRepository;
            case "material_type" -> materialTypeRepository;
            case "material_conv" -> materialConversationRepository;
            case "material" -> materialRepository;
            case "operators" -> operatorRepository;
            case "operator_on_equip" -> operatorOnEquipRepository;
            case "operator_on_equip_type" -> operatorOnEquipTypeRepository;
            case "sensor_types" -> sensorTypeRepository;
            case "sensor_inclin_calibration" -> sensorInclineCalibrationRepository;
            case "sensor_data_types" -> sensorDataTypeRepository;
            case "sensors" -> sensorRepository;
            case "shifts" -> shiftRepository;
            case "statuses" -> statusesRepository;
            case "status_cat" -> statusCategoryRepository;
            case "status_cat_location_rel" -> statusCatLocationRelRepository;
            case "status_group" -> statusGroupRepository;
            case "status_group_rel" -> statusGroupRelationRepository;
            case "status_inh" -> statusInheritanceRepository;
            case "routes" -> routesRepository;
            case "routes_roads" -> routesRoadsRepository;

            default ->  null;
        };
    }

}
