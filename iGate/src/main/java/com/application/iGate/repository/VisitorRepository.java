package com.application.iGate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.iGate.model.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, UUID>{

}
