package com.group.activities.bowling.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.activities.bowling.dto.PlayerDto;
import com.group.activities.bowling.entity.IPlayer;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    PlayerDto toDto(IPlayer player);
    
}
