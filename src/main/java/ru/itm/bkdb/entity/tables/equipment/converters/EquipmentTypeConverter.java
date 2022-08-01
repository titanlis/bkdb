package ru.itm.bkdb.entity.tables.equipment.converters;


import ru.itm.bkdb.entity.tables.equipment.EQUIPMENT_TYPE;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class EquipmentTypeConverter implements AttributeConverter<EQUIPMENT_TYPE, String> {

    @Override
    public String convertToDatabaseColumn(EQUIPMENT_TYPE attribute) {
        if(attribute==null){
            return null;
        }
        return attribute.name();
    }

    @Override
    public EQUIPMENT_TYPE convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        EQUIPMENT_TYPE e = Stream.of(EQUIPMENT_TYPE.values())
                .filter(c -> c.name().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(e);

        return e;
    }

}
