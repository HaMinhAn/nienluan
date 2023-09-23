package com.example.nienluan.repository;

import com.example.nienluan.models.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Integer>, PagingAndSortingRepository<Phone, Integer> {

  Optional<Phone> findByName(String name);
}
