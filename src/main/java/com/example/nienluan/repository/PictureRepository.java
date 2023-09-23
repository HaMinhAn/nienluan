package com.example.nienluan.repository;

import com.example.nienluan.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Integer> {

  Optional<Picture> findByCaption(String caption);
}
