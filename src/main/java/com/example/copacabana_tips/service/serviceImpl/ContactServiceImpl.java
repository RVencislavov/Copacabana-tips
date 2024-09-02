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
        List<ContactEntity> contactEntities = contactRepository.findByDeletedFalse();
        return contactEntities.stream()
                .map(contactMapper::toDto)
                .toList();
    }
    @Override
    public void deleteContact(Long id) {
        ContactEntity contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        LocalDateTime thresholdDateTime = LocalDateTime.now().minusDays(30);
        if (contact.getCreatedDate().isAfter(thresholdDateTime)) {
            throw new RuntimeException("Cannot delete a contact created within the last 30 days.");
        }

        contact.setDeleted(true);
        contactRepository.save(contact);
    }
}


