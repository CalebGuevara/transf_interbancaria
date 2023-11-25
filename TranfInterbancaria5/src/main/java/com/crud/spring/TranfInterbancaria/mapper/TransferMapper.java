package com.crud.spring.TranfInterbancaria.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.crud.spring.TranfInterbancaria.dto.TransferDTO;
import com.crud.spring.TranfInterbancaria.entity.Transfer;

@Mapper
public interface TransferMapper {
	
	TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);
	
	@Mapping(target = "sourceAccount", source = "sourceAccount")
    @Mapping(target = "destinationAccount", source = "destinationAccount")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "currency", source = "currency")
	TransferDTO entityToDTO(Transfer transfer);
	
	Transfer dtoToEntity(TransferDTO transferDTO);
	
}
