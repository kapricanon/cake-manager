package com.waracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waracle.model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Integer> {

}
