package dev.redonkuci.manuopsmanufacturingapp.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleMapper <TEntity, TDto> {
    TDto toDto(TEntity entity);
    TEntity toEntity(TDto dto);
}
