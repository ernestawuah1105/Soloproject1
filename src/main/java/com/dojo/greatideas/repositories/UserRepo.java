package com.dojo.greatideas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.dojo.greatideas.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	public User findByEmail(String email);

}
