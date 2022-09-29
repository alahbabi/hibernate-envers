package com.capgemini.audit.jpa;

import com.capgemini.audit.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface PersonRepository extends RevisionRepository<Person, Integer, Integer>, JpaRepository<Person, Integer> {

}
