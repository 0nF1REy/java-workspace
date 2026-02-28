package dev.alanryan.tddwebflux.api.repository;

import dev.alanryan.tddwebflux.api.model.Stack;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends ReactiveMongoRepository<Stack, String> {}
