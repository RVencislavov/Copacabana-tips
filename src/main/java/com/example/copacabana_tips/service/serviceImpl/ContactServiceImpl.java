package com.example.copacabana_tips.service.serviceImpl;

import com.example.copacabana_tips.mapper.ContactMapper;
import com.example.copacabana_tips.model.dto.ContactDto;
import com.example.copacabana_tips.model.entity.ContactEntity;
import com.example.copacabana_tips.repository.ContactRepository;
import com.example.copacabana_tips.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    public ContactDto addContact(ContactDto contactDto) {
        ContactEntity contactEntity = contactMapper.toEntity(contactDto);
        contactEntity.setCreatedDate(LocalDateTime.now());
        ContactEntity savedContact = contactRepository.save(contactEntity);
        return contactMapper.toDto(savedContact);
    }
    @Override
    public List<ContactDto> getAllContacts() {
        List<ContactEntity> contactEntities = contactRepository.findAll();
        return contactEntities.stream()
                .map(contactMapper::toDto)
                .toList();
    }
}


