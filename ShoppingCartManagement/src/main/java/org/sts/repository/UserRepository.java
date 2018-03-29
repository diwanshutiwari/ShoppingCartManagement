package org.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sts.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);

}
