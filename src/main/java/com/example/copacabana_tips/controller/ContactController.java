package com.example.copacabana_tips.controller;

import com.example.copacabana_tips.model.dto.ContactDto;
import com.example.copacabana_tips.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/add")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new ContactDto());
        return "add-contact";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute ContactDto contactDto, Model model) {
        contactService.addContact(contactDto);
        return "redirect:/contacts/all";
    }

    @GetMapping("/all")
    public String getAllContacts(Model model) {
        List<ContactDto> contacts = contactService.getAllContacts();
        LocalDate thresholdDate = LocalDate.now().minusDays(30);
        model.addAttribute("contacts", contacts);
        model.addAttribute("thresholdDate", thresholdDate);
        return "all-contacts";
    }
    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id, Model model) {
        try {
            contactService.deleteContact(id);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            List<ContactDto> contacts = contactService.getAllContacts();
            LocalDate thresholdDate = LocalDate.now().minusDays(30);
            model.addAttribute("contacts", contacts);
            model.addAttribute("thresholdDate", thresholdDate);
            return "all-contacts";
        }
        return "redirect:/contacts/all";
    }
}
