package com.example.copacabana_tips.model.dto;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class ContactDto {

    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;

    private LocalDateTime createdDate;

    public ContactDto() {

    }
}

