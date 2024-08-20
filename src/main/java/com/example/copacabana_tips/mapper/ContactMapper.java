package com.example.copacabana_tips.mapper;

import com.example.copacabana_tips.model.dto.ContactDto;
import com.example.copacabana_tips.model.entity.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    public ContactEntity toEntity(ContactDto contactDto);
    public ContactDto toDto(ContactEntity contactEntity);
}
