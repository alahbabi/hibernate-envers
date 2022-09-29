package com.capgemini.audit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EnableJpaAuditing
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
}
