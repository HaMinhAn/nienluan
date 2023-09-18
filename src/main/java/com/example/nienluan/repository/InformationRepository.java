package com.example.nienluan.repository;


import com.example.nienluan.models.InformationAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InformationRepository extends JpaRepository<InformationAccount,Long> {

}
