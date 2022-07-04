package com.nelioalves.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Person;

@Repository
public interface UserRepository extends MongoRepository<Person, String> {
	
	
}
