package com.example.copacabana_tips.repository;

import com.example.copacabana_tips.model.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
