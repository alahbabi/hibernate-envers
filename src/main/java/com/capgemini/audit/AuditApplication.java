package com.capgemini.audit;

import com.capgemini.audit.entities.Person;
import com.capgemini.audit.jpa.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class AuditApplication {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping("/updatePerson/{id}/{name}")
	public void updatePerson(@PathVariable int id, @PathVariable String name) {
		Person person = personRepository.findById(id).get();
		person.setName(name);
		personRepository.save(person);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable int id) {
		personRepository.deleteById(id);
	}
	public static void main(String[] args) {
		SpringApplication.run(AuditApplication.class, args);
	}

}
