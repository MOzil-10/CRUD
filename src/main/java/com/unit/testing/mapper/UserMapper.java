package com.unit.testing.mapper;

import com.unit.testing.dto.UserDto;
import com.unit.testing.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(UserEntity user);
    UserEntity dtoToEntity(UserDto userDto);
}
