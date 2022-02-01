package com.example.leaf.repository;

import com.example.leaf.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, Long> {

    public Researcher findByEmail(String email);




}
