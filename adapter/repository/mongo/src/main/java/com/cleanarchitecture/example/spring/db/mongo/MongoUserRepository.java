package com.cleanarchitecture.example.spring.db.mongo;

import com.cleanarchitecture.example.domain.entity.User;
import com.cleanarchitecture.example.usecase.port.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoUserRepository extends UserRepository, MongoRepository<User, String> {
	@Override
	default User create(User user) {
		return save(user);
	}

	@Override
	default List<User> findAllUsers() {
		return findAll();
	}
}
