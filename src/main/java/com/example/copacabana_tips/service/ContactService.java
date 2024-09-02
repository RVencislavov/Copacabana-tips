package com.example.copacabana_tips.service;

import com.example.copacabana_tips.model.dto.ContactDto;

import java.util.List;

public interface ContactService {
    public ContactDto addContact(ContactDto contactDto);

    List<ContactDto> getAllContacts();
    public void deleteContact(Long id);
}
