package com.example.whipCarrotDB;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUserId(String user_id);
}
